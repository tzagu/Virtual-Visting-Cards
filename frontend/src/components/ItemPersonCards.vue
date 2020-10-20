<template>
<v-container fluid class="inspire fill-height">
  <v-row>
<v-col v-for="(itemPerson, index) in itemPerson" :key="index">
    <v-card
    :elevation="12"
    shaped
    max-width="400px"
  >
    <v-list-item three-line>
      <v-list-item-content>
        <div class="overline mb-4">{{itemPerson.id}}</div>
        <v-list-item-title class="headline mb-1">Price: {{itemPerson.price}}</v-list-item-title>
        <v-list-item-subtitle>Brand: {{itemPerson.brand}}</v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>

    <v-card-actions>
      <v-btn text @click="cardDetails(itemPerson.id)">Details</v-btn>
      <v-btn text>Contact</v-btn>
    </v-card-actions>
  </v-card>
  </v-col>
  </v-row>
</v-container>
</template>

<script>
import axios from 'axios'

export default {
  data(){
    return{

    itemPerson: [],
    }
  },
  methods: {
    findAll(){
      return axios.get("/itempersoncards").then(response=>{
        this.itemPerson = response.data;
      })
      .catch(e=>{
        console.log(e);
      });
    },
    cardDetails(id){
      this.$store.commit("setCardId", id)
      console.log(this.$store.state.cardData.id)
      this.$router.replace({name: "CardClicked"})
    }
  },
  mounted() {
    this.findAll();
    console.log(this.$store.state.user.name + " logged in")
  }

}
</script>

<style>
.inspire{
    background-color: #36213E;}
</style>
