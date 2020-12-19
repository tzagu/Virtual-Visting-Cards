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
      cards: [],
    };
  },
  methods: {
    searchByEmail() {
      this.cards = []
      for(let i = 0; i < this.$store.state.allItemPersonCards.length; i++){
        if(this.$store.state.allItemPersonCards[i].person.email === this.searchBy){
          this.cards.push(this.$store.state.allItemPersonCards[i])
        }
      }
    },
    searchByName() {
      this.cards = []
      for(let i = 0; i < this.$store.state.allItemPersonCards.length; i++){
        if(this.$store.state.allItemPersonCards[i].person.name === this.searchBy){
          this.cards.push(this.$store.state.allItemPersonCards[i])
        }
      }
    },
    searchByDateRange() {
      this.cards = []
      for(let i = 0; i < this.$store.state.allItemPersonCards.length; i++){
        if(this.$store.state.allItemPersonCards[i].date >= this.daterange[0] && this.$store.state.allItemPersonCards[i].date <= this.daterange[1]){
          this.cards.push(this.$store.state.allItemPersonCards[i])
        }
      }
    },
  },
};
</script>

<style>
</style>