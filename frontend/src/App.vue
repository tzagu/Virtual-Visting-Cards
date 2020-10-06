<template>
  <div class="inspire">
    <v-app-bar dark elevate-on-scroll  scroll-target="#scrolling-techniques-7" color="#36213E" class="my-4">

      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon>mdi-message-outline</v-icon>
      </v-btn>

      <v-btn icon>
        <v-icon>mdi-account-outline</v-icon>
      </v-btn>

      <v-btn icon>
        <v-icon>mdi-dots-vertical</v-icon>
      </v-btn>
    </v-app-bar>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
.inspire{
    background-color: #36213E;}
</style>
