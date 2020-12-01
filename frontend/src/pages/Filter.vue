<template>
  <v-app class="inspire inspire">
    <v-main class="inspire inspire">
      <v-container>
        <v-card>
          <v-form class="ma-12 pa-8">
            <v-row>
              <v-col>
                <h3>Filter results</h3>
                <v-select
                  v-model="location"
                  :items="locations"
                  label="Location"
                ></v-select>
                <v-select
                  v-model="item"
                  :items="itemNames"
                  label="Item"
                ></v-select>
                <v-subheader>Price range</v-subheader>

                <v-range-slider
                  v-model="range"
                  :max="max"
                  :min="min"
                  hide-details
                  class="align-center"
                >
                  <template v-slot:prepend>
                    <v-text-field
                      :value="range[0]"
                      class="mt-0 pt-0"
                      hide-details
                      single-line
                      type="number"
                      style="width: 60px"
                      @change="$set(range, 0, $event)"
                    ></v-text-field>
                  </template>
                  <template v-slot:append>
                    <v-text-field
                      :value="range[1]"
                      class="mt-0 pt-0"
                      hide-details
                      single-line
                      type="number"
                      style="width: 60px"
                      @change="$set(range, 1, $event)"
                    ></v-text-field>
                  </template>
                </v-range-slider>
                <v-select
                  v-model="partnerType"
                  :items="partnerTypes"
                  label="Partner type"
                ></v-select>

                <v-btn
                  @click.prevent="filterSearch"
                  absolute
                  right
                  class="white--text"
                  color="#36213e"
                  >Search</v-btn
                >
              </v-col>
            </v-row>
          </v-form>
        </v-card>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import Axios from "axios";
export default {
  data() {
    return {
      location: "",
      category: "",
      item: "",
      partnerType: "",
      min: 0,
      max: 10000,
      slider: 40,
      range: [0, 500],
      locations: [
        "Any",
        "Ampara",
        "Anuradhapura",
        "Badulla",
        "Batticaloa",
        "Colombo",
        "Galle",
        "Gampaha",
        "Hambantota",
        "Jaffna",
        "Kalutara",
        "Kandy",
        "Kegalle",
        "Kilinochchi",
        "Kurunegala",
        "Mannar",
        "Matale",
        "Matara",
        "Moneragala",
        "Mullaitivu",
        "Nuwara Eliya",
        "Polonnaruwa",
        "Puttalam",
        "Ratnapura",
        "Trincomalee",
        "Vavuniya",
      ],
      dataSet: [], //response dataset in mounted
      itemNames: [],
      categorisedItems: [],
      partnerTypes: ["Buyer", "Seller"],
      tempObj: {},
      filterData: [],
    };
  },
  methods: {
    filterSearch() {
      this.tempObj.filtered = true,
      this.tempObj.filterLocation = this.location;
      this.tempObj.filterCategory = this.category;
      this.tempObj.filterItem = this.item;
      this.tempObj.filterMinPrice = this.range[0];
      this.tempObj.filterMaxPrice = this.range[1];
      this.tempObj.filterPartnerType = this.partnerType;
      this.filterData.push(this.tempObj);
      this.$store.commit("setFilter", this.filterData);
      this.$router.push({name: "ItemPersonCards"})
    },
  },
  mounted() {
    Axios.get("/categories")
      .then((response) => {
        this.dataSet = response.data;
        for (let i = 0; i < this.dataSet.length; i++) {
          for (let j = 0; j < this.dataSet[i].items.length; j++) {
            this.itemNames.push(this.dataSet[i].items[j].name);
          }
          this.categorisedItems.push(this.dataSet[i].name);
        }
      })
      .catch((e) => {
        console.log(e);
      });
  },
};
</script>

<style scoped>
.inspire {
  background-color: #36213e;
}
</style>
