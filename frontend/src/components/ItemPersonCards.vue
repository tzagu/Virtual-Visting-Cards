<template>
  <v-container fluid class="inspire fill-height">
    <v-row>
      <v-col v-for="(itemPerson, index) in itemPerson" :key="index">
        <v-card :elevation="12" shaped min-width="400px">
          <v-list-item three-line>
            <v-list-item-content>
              <div class="overline mb-4">Posted by {{ itemPerson.person.name }}</div>

              <v-list-item-title class="headline mb-1">
          {{itemPerson.item.name}}
        </v-list-item-title>
              <v-list-item-subtitle
                >Brand: {{ itemPerson.brand }}</v-list-item-subtitle
              >

              <v-list-item-subtitle class="headline mb-1"
                >Price: {{ itemPerson.price }}</v-list-item-subtitle
              >
            </v-list-item-content>
          </v-list-item>

          <v-card-actions>
            <v-btn text @click.prevent="cardDetails(itemPerson.id)"
              >Details</v-btn
            >
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      itemPerson: [],
      splicingItemPerson: [], //used to temporarily save the response objects and filter data to the itemPerson array
    };
  },
  methods: {
    findAll() {
      if (this.$store.state.filter.filtered === false) {
        return axios
          .get("/itempersoncards")
          .then((response) => {
            this.itemPerson = response.data;
            for (let i = 0; i < response.data.length; i++) {
              this.$store.commit("setAllItemPersonCards", response.data[i]);
            }
          })
          .catch((e) => {
            console.log(e);
          });
      } else {
        axios.get("/itempersoncards").then((response) => {
          if (this.$store.state.filter.location != "" || null) {
            for (let i = 0; i < response.data.length; i++) {
              if (
                response.data[i].deliverTo === this.$store.state.filter.location
              ) {
                console.log(response.data[i]);
                this.splicingItemPerson.push(response.data[i]);
              }
            }
          }
          else{
            for(let i = 0; i<response.data.length; i++){
              this.splicingItemPerson.push(response.data[i]);
            }
          }
          if (this.$store.state.filter.item != "") {
            for (let j = 0; j < this.splicingItemPerson.length; j++) {
              if (
                this.splicingItemPerson[j].item.name != this.$store.state.filter.item
              ) {
                this.splicingItemPerson.splice(j, 1);
              }
            }
          }
          if (this.$store.state.filter.partnerType != "") {
            for (let k = 0; k < this.splicingItemPerson.length; k++) {
              if (
                this.splicingItemPerson[k].person.type != this.$store.state.filter.partnerType
              ) {
                this.splicingItemPerson.splice(k, 1);
              }
            }
          }
          
          if (this.$store.state.filter.maxPrice != 0) {
            for (let m = 0; m < this.splicingItemPerson.length; m++) {
              if (
                this.splicingItemPerson[m].price >
                  this.$store.state.filter.maxPrice ||
                this.splicingItemPerson[m].price <
                  this.$store.state.filter.minPrice
              ) {
                console.log("spliced")
                this.splicingItemPerson.splice(m, 1);
              }
              else{
                console.log("splicing skipped")
              }
            }
          };
                for (let n = 0; n < this.splicingItemPerson.length; n++) {
        this.itemPerson.push(this.splicingItemPerson[n]);
      }
      console.log(this.splicingItemPerson);
        });
    }
    },
    cardDetails(id) {
      this.$store.commit("setCardId", id);
      console.log(this.$store.state.cardData.id);
      this.$router.push({ name: "CardClicked" });
    },
  },
  mounted() {
    this.findAll();
    console.log(this.$store.state.user.name + " logged in");
  },
};
</script>

<style>
.inspire {
  background-color: #36213e;
}
</style>
