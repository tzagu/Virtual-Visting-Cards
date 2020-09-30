<template>
<v-container fluid class="inspire">
  <v-row>
<v-col v-for="(itemPerson, index) in itemPerson" :key="index">
    <v-card
    :elevation="12"
    shaped
  >
    <v-list-item three-line>
      <v-list-item-content>
        <div class="overline mb-4">{{itemPerson.name}}</div>
        <v-list-item-title class="headline mb-1">{{itemPerson.price}}</v-list-item-title>
        <v-list-item-subtitle>{{itemPerson.brand}}</v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>

    <v-card-actions>
      <v-btn text>Details</v-btn>
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
    }
  },
  mounted() {
    this.findAll();
  }

}
</script>

<style>
.inspire{
    background-color: #36213E;}
</style>
