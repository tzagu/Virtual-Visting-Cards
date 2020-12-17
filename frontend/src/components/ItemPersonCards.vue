<template>
  <v-main>
    <v-layout>
      <v-container class="fill-height inspire" fluid>
        <v-row>
          <v-col v-for="(itemPerson, index) in itemPerson" :key="index">
            <v-card :elevation="12" shaped min-width="300px" class="cards">
              <v-list-item three-line>
                <v-list-item-content>
                  <div class="overline mb-4" @click.prevent="showAlert">
                    Posted by {{ itemPerson.person.name }}
                  </div>

                  <v-list-item-title class="headline mb-1">
                    {{ itemPerson.item.name }}
                  </v-list-item-title>
                  <v-list-item-subtitle
                    >Brand: {{ itemPerson.brand }}</v-list-item-subtitle
                  >

                  <v-list-item-subtitle class="overline mb-4"
                    >Price: {{ itemPerson.price }}</v-list-item-subtitle
                  >
                </v-list-item-content>
              </v-list-item>

              <v-card-actions>
                <v-btn
                  color="#36213e"
                  text
                  @click.prevent="cardDetails(itemPerson.id)"
                  >Details</v-btn
                >
              </v-card-actions>
            </v-card>
          </v-col>
              <v-snackbar
    :value="snackbar"
      v-model="snackbar"
      :timeout="timeout"
      shaped
      top
      color="blue-grey"
      transition="fab-transition"
    >
      {{ text }}
    </v-snackbar>
        </v-row>
      </v-container>
    </v-layout>
  </v-main>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      itemPerson: [],
      splicingItemPerson: [], //used to temporarily save the response objects and filter data to the itemPerson array
      tempArray: [],
      snackbar: false,
      text: "",
      timeout: 5000,
    };
  },
  methods: {
    getAllCardsFromAxios() {
      return axios
        .get("/itempersoncards")
        .then((response) => {
          if(response.data.length == 0){
            this.text = "No data for your filter"
            this.snackbar = true
          }
          else{
            //Go outside an stare at the sky until a star comes down
          }
          for (let i = 0; i < response.data.length; i++) {
            this.$store.commit("setAllItemPersonCards", response.data[i]);
          }

          if (this.$store.state.filter.filtered === false) {
            this.showAllCards();
          } else {
            this.filterCards();
          }
        })
        .catch((e) => {
          console.log(e);
        });
    },
    cardDetails(id) {
      this.$store.commit("setCardId", id);
      this.$router.push({ name: "CardClicked" });
    },
    filterCards() {
      if (this.$store.state.filter.location != "") {
        for (let x = 0; x < this.getReverseCards.length; x++) {
          if (
            this.getReverseCards[x].deliverTo ==
            this.$store.state.filter.location
          ) {
            this.splicingItemPerson.push(
              this.getReverseCards[x]
            );
          } else {
            console.log("");
          }
        }
      } else {
        for (let i = 0; i < this.getReverseCards.length; i++) {
          this.splicingItemPerson.push(this.getReverseCards[i]);
        }
      }

      if (this.$store.state.filter.item != "") {
        for (let j = 0; j < this.splicingItemPerson.length; j++) {
          if (
            this.splicingItemPerson[j].item.name ===
            this.$store.state.filter.item
          ) {
            this.tempArray.push(this.splicingItemPerson[j]);
          } else {
            console.log("");
          }
        }
      } else {
        for (let j = 0; j < this.splicingItemPerson.length; j++) {
          this.tempArray.push(this.splicingItemPerson[j]);
        }
      }
      this.splicingItemPerson = [];

      if (this.$store.state.filter.partnerType != "") {
        for (let k = 0; k < this.tempArray.length; k++) {
          if (
            this.tempArray[k].person.type ===
            this.$store.state.filter.partnerType
          ) {
            this.splicingItemPerson.push(this.tempArray[k]);
          }
        }
      } else {
        for (let k = 0; k < this.tempArray.length; k++) {
          this.splicingItemPerson.push(this.tempArray[k]);
        }
      }
      this.tempArray = [];

      if (this.$store.state.filter.maxPrice !== 0) {
        for (let m = 0; m < this.splicingItemPerson.length; m++) {
          if (
            this.splicingItemPerson[m].price <=
              this.$store.state.filter.maxPrice &&
            this.splicingItemPerson[m].price >=
              this.$store.state.filter.minPrice
          ) {
            this.tempArray.push(this.splicingItemPerson[m]);
          } else {
            console.log("range");
          }
        }
      } else {
        console.log("0");
      }
      for (let n = 0; n < this.tempArray.length; n++) {
        this.itemPerson.push(this.tempArray[n]);
      }

    },

    showAllCards() {
      for (let i = 0; i < this.getReverseCards.length; i++) {
        this.itemPerson.push(this.getReverseCards[i]);
      }
    },

    checkStatus() {
      if (this.$store.state.allItemPersonCards.length == 0) {
        this.getAllCardsFromAxios();
      } else {
        if (this.$store.state.filter.filtered === false) {
            this.showAllCards();
          } else {
            this.filterCards();
          }
      }
    },
    showAlert(){
      this.text = "Only premium members can view a person profile"
      this.snackbar = true
    }
  },
  mounted() {
    this.checkStatus();
  },
  computed: {
    getReverseCards(){
      return this.$store.getters.reverseItems
    }
  }
};
</script>

<style>
.inspire {
  background-color: #36213e;
}
.cards {
  background: linear-gradient(
    135deg,
    rgba(255, 255, 0, 1) 0%,
    rgba(200, 208, 221, 1) 7%,
    rgba(255, 255, 255, 1) 35%,
    rgba(253, 253, 254, 1) 61%,
    rgba(195, 202, 216, 1) 81%,
    rgba(54, 33, 62, 1) 100%
  );
}
</style>