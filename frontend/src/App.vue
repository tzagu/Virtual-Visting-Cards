// TODO
//methods must show the respective menus of links

<template>
  <div class="inspire">
    <v-app-bar dark elevate-on-scroll  color="#36213E" class="my-4">

      <v-btn @click.prevent="showItemPersonCards" icon>
        <v-icon>mdi-home-outline</v-icon>
      </v-btn>

      <v-spacer></v-spacer>

      <v-btn @click.prevent="showFilter" icon>
        <v-icon>mdi-filter-outline</v-icon>
      </v-btn>

      <v-btn @click.prevent="showProfileActivities" icon>
        <v-icon>mdi-account-outline</v-icon>
      </v-btn>

      <v-btn @click.prevent="showOptions" icon>
        <v-icon>mdi-dots-vertical</v-icon>
      </v-btn>
    </v-app-bar>
    <router-view class = "inspire"/>
  </div>
</template>

<script>
export default {
  name: 'App',

  methods: {
    showItemPersonCards(){
      this.$store.commit("setFilterStatus", false)
      window.location.reload()
    },
    showFilter(){
      this.$router.push({name: "Filter"})
    },
    showProfileActivities(){
      this.$router.push({name: "MyDeals"})
    },
    showOptions(){
      this.$router.push({name: "ContactUs"})
    },
  }
}
</script>

<style>
.inspire{
    background-color: #36213E;
    background: #36213E;
    }
</style>
