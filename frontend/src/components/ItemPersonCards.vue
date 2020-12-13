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
                  class="grey--text"
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
      text: "Only premium members can view a person profile",
      timeout: 5000,
    };
  },
  methods: {
    getAllCardsFromAxios() {
      console.log("calling axios ...");
      return axios
        .get("/itempersoncards")
        .then((response) => {
          for (let i = 0; i < response.data.length; i++) {
            this.$store.commit("setAllItemPersonCards", response.data[i]);
          }
          console.log(this.$store.state.allItemPersonCards);

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
      console.log(this.$store.state.cardData.id);
      this.$router.push({ name: "CardClicked" });
    },
    filterCards() {
      console.log("filtered");
      if (this.$store.state.filter.location != "") {
        console.log("location not empty");
        for (let x = 0; x < this.$store.state.allItemPersonCards.length; x++) {
          if (
            this.$store.state.allItemPersonCards[x].deliverTo ==
            this.$store.state.filter.location
          ) {
            this.splicingItemPerson.push(
              this.$store.state.allItemPersonCards[x]
            );
          } else {
            console.log("skipping unmatched location");
          }
        }
      } else {
        console.log("location empty. Adding all");
        for (let i = 0; i < this.$store.state.allItemPersonCards.length; i++) {
          this.splicingItemPerson.push(this.$store.state.allItemPersonCards[i]);
        }
      }

      if (this.$store.state.filter.item != "") {
        for (let j = 0; j < this.splicingItemPerson.length; j++) {
          if (
            this.splicingItemPerson[j].item.name ===
            this.$store.state.filter.item
          ) {
            console.log("Item names matched");
            console.log(this.splicingItemPerson[j].item.name);
            this.tempArray.push(this.splicingItemPerson[j]);
          } else {
            console.log("item names does not match. skipping");
            console.log(this.splicingItemPerson[j].item.name);
          }
        }
        console.log("Array after name comparison");
        console.log(this.splicingItemPerson);
      } else {
        console.log("item name empty. tranferring all");
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
            console.log("partnerType matched.");
            console.log(this.tempArray[k].person.type);
            this.splicingItemPerson.push(this.tempArray[k]);
          }
        }
      } else {
        console.log("partner type empty. tranferring all");
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
            console.log("price range matched");
            console.log(this.splicingItemPerson[m].price);
            this.tempArray.push(this.splicingItemPerson[m]);
          } else {
            console.log("not in price range");
            console.log(this.splicingItemPerson[m].price);
          }
        }
        console.log(this.tempArray);
      } else {
        console.log("max price cannot be 0");
      }
      console.log("final array");
      console.log(this.tempArray);
      for (let n = 0; n < this.tempArray.length; n++) {
        this.itemPerson.push(this.tempArray[n]);
      }

      console.log("end of filtering");
    },

    showAllCards() {
      console.log("no filtering. showing all");
      for (let i = 0; i < this.$store.state.allItemPersonCards.length; i++) {
        this.itemPerson.push(this.$store.state.allItemPersonCards[i]);
      }
    },

    checkStatus() {
      console.log("Checking status...");
      if (this.$store.state.allItemPersonCards.length == 0) {
        console.log("No data in the store. calling axios...");
        this.getAllCardsFromAxios();
      } else {
        console.log("Data exists in the store. importing ...");
        if (this.$store.state.filter.filtered === false) {
            this.showAllCards();
          } else {
            this.filterCards();
          }
      }
      console.log(this.$store.state.user.name + " logged in");
    },
    showAlert(){
      this.snackbar = true
    }
  },
  mounted() {
    console.log("mounted");
    this.checkStatus();
  },
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