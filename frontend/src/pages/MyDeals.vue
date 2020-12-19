//TODO not mobile responsive

<template>
  <v-row justify="center" align="center" class="ma-8">
    <v-row>
      <v-col cols="2" class="mr-2">
        <v-header class="white--text">My Cards</v-header>
      </v-col>

      <v-col cols="10">
        <v-row>
          <v-card
            v-for="card in myCardList"
            :key="card"
            max-width="300px"
            class="ma-4"
          >
            <v-card-title>
              <v-spacer></v-spacer>
              <v-btn icon color="#36213e" @click="deleteCard(card.id)">
              <v-icon> mdi-delete </v-icon>
              </v-btn>
            </v-card-title>
            <v-list-item three-line>
              <v-list-item-content>
                <div class="overline mb-4">Brand: {{ card.brand }}</div>
                <v-list-item-title class="headline mb-1">
                  {{ card.item.name }}
                </v-list-item-title>
                <v-list-item-subtitle
                  >Delivering to {{ card.deliverTo }}</v-list-item-subtitle
                >
                <v-list-item-subtitle
                  >Price: {{ card.price }}</v-list-item-subtitle
                >
                <v-list-item-subtitle>{{
                  card.person.type
                }}</v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
          </v-card>
        </v-row>
      </v-col>
    </v-row>
    <!-- ======================================================================== row ============================================================== -->
    <!-- <v-row>
      <v-col cols="2" class="mr-2">
        <v-header class="white--text">Contacted partners</v-header>
      </v-col>

      <v-col cols="10">
        <v-row>
          <v-card
            v-for="card in mycards"
            :key="card"
            max-width="300px"
            class="ma-4"
          >
            <v-list-item three-line>
              <v-list-item-content>
                <div class="overline mb-4">
                  {{ card.username }}
                </div>
                <v-list-item-title class="headline mb-1">
                  {{ card.item }}
                </v-list-item-title>
                <v-list-item-subtitle>{{ card.email }}</v-list-item-subtitle>
                <v-list-item-subtitle>{{ card.mobile }}</v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
          </v-card>
        </v-row>
      </v-col>
    </v-row> -->
  </v-row>
</template>

<script>
import Axios from 'axios'
export default {
  data() {
    return {
      // mycards: [
      //   {
      //     username: "Tzagu",
      //     item: "computers",
      //     location: "All",
      //     price: 100,
      //     status: "premium",
      //     email: "tzaguyapa@gmail.com",
      //     mobile: 77710234,
      //   },

      //   {
      //     username: "Zale", //Sea strength
      //     item: "mobiles",
      //     location: "All",
      //     price: 300,
      //     status: "premium",
      //     email: "tzaguyapa@gmail.com",
      //     mobile: 777109226,
      //   },

      //   {
      //     username: "Naida", //Water nymph
      //     item: "masks",
      //     location: "Colombo",
      //     price: 10.5,
      //     status: "pending",
      //     email: "tzaguyapa@gmail.com",
      //     mobile: 776452105,
      //   },

      //   {
      //     username: "Darya", //The sea
      //     item: "vegetables",
      //     location: "All",
      //     price: 0.0,
      //     status: "Buyer",
      //     email: "tzaguyapa@gmail.com",
      //     mobile: 776452105,
      //   },

      //   {
      //     username: "Fig",
      //     item: "Cotton",
      //     location: "All",
      //     price: 4.55,
      //     status: "premium",
      //     email: "tzaguyapa@gmail.com",
      //     mobile: 777109226,
      //   },
      // ],
      myCardList: [],
    };
  },
  methods:{
    deleteCard(id){
      Axios.delete("/deleteitemperson/" + id).then((response) => {
        this.$swal("Deleted!", "It may take a while to update your changes.", {buttons: false})
      }).catch((error) => {
        console.log(error)
      })
    }
  },

  mounted() {
    for (let i = 0; i < this.$store.state.allItemPersonCards.length; i++) {
      if (this.$store.state.allItemPersonCards[i].person != null) {
        if (
          this.$store.state.allItemPersonCards[i].person.id ===
          this.$store.state.user.id
        ) {
          this.myCardList.push(this.$store.state.allItemPersonCards[i]);
        }
      }
    }
  },
};
</script>

<style scoped>
.inspire {
  background-color: #36213e;
}
</style>