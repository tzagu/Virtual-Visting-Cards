
<template>
  <div class="inspire">
    <v-app class="inspire">
      <v-main style="padding: 0px 0px 0px;">
      <v-container class="fill-height inspire" fluid>
    <ToolBar />
    <router-view class="inspire" />
      </v-container>
      </v-main>
    </v-app>
  </div>
</template>

<script>
import ToolBar from "./components/ToolBar"
export default {
  name: "App",
  components: {
    ToolBar,
  }
};
</script>

<style>
.inspire {
  background-color: #36213e;
  background: #36213e;
}
</style>
