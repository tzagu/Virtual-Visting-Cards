<template>
  <v-card>
    <v-card-title>
      <v-text-field
        placeholder="Email or Name"
        v-model="searchBy"
      ></v-text-field>
      <v-row>
        <v-col>
          <v-btn class="white--text" color="#36213e" @click="searchByEmail"
            >Email</v-btn
          >
        </v-col>
        <v-spacer></v-spacer>
        <v-col>
          <v-btn class="white--text" color="#36213e" @click="searchByName"
            >User name</v-btn
          >
        </v-col>
      </v-row>
    </v-card-title>
    <v-card-text>
      <v-date-picker
        v-model="daterange"
        range
        no-title
        color="#36213e"
        full-width
      ></v-date-picker>
      <v-row align="center" justify="center">
        <v-col>
          <v-btn right class="white--text" color="#36213e" @click="searchByDateRange"
            >Search</v-btn
          >
        </v-col>
      </v-row>






      <v-row>
          <v-col v-for="(cards, index) in cards" :key="index">
            <v-card shaped min-width="300px">
              <v-card-title>
                  <v-row>
                      <v-col>
                          {{cards.person.name}}
                      </v-col>
                      <v-spacer></v-spacer>
                      <v-col>
                          {{cards.id}}
                      </v-col>
                  </v-row>
              </v-card-title>
              <v-card-text>
                  <!-- consume other data from cards here -->
              </v-card-text>
            </v-card>   
          </v-col>
        </v-row>





    </v-card-text>
  </v-card>
</template>

<script>
export default {
  data() {
    return {
      searchBy: "",
      daterange: [],
      cards: [
        {
          id: 0,
          date: "2020-12-18",
          brand: "brand",
          deliverTo: "deliverTo",
          quantity: "quantity",
          price: 23.02,
          rating: 4,
          deals: [{ id: 1, date: "2020-12-08" },{ id: 2, date: "2020-09-08" }],
          item: { id: 1, name: "item name" },
          person: {
            id: 2,
            name: "tzagu",
            mobile1: "mobile 1",
            joinedDate: "2020-18-02",
            email: "tzaguyapa@gmail.com",
            status: "newbie",
            rating: 3,
            type: "Buyer",
            deals: [{ id: 5, date: "1292-09-12" }, { id: 7, date: "2020-09-12" }],
          },
        },
        {
          id: 0,
          date: "2020-12-18",
          brand: "brand",
          deliverTo: "deliverTo",
          quantity: "quantity",
          price: 23.02,
          rating: 4,
          deals: [{ id: 1, date: "2020-12-08" },{ id: 2, date: "2020-09-08" }],
          item: { id: 1, name: "item name" },
          person: {
            id: 2,
            name: "tzagu",
            mobile1: "mobile 1",
            joinedDate: "2020-18-02",
            email: "tzaguyapa@gmail.com",
            status: "newbie",
            rating: 3,
            type: "Buyer",
            deals: [{ id: 5, date: "1292-09-12" }, { id: 7, date: "2020-09-12" }],
          },
        },
        {
          id: 0,
          date: "2020-12-18",
          brand: "brand",
          deliverTo: "deliverTo",
          quantity: "quantity",
          price: 23.02,
          rating: 4,
          deals: [{ id: 1, date: "2020-12-08" },{ id: 2, date: "2020-09-08" }],
          item: { id: 1, name: "item name" },
          person: {
            id: 2,
            name: "tzagu",
            mobile1: "mobile 1",
            joinedDate: "2020-18-02",
            email: "tzaguyapa@gmail.com",
            status: "newbie",
            rating: 3,
            type: "Buyer",
            deals: [{ id: 5, date: "1292-09-12" }, { id: 7, date: "2020-09-12" }],
          },
        },
      ],
    };
  },
  methods: {
    searchByEmail() {},
    searchByName() {},
    searchByDateRange() {},
  },
};
</script>

<style>
</style>