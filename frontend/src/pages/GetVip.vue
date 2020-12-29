<template>
  <v-main class="bgimage" style="padding: 0px 0px 0px">
    <v-row class="fill-height" align="center" justify="center">
      <v-row>
        <v-col class="text-center gradiant ma-2 pa-2" cols="12">
          <h1 class="mb-4 white--text">Raymerge VIP</h1>
          <h3 class="subheading white--text">
            Great Day {{ this.$store.state.user.name }} !
          </h3>
          <h4 class="subtitle-1 white--text mb-4">
            You are currently not eligible for this tier
          </h4>
          <h4 class="subtitle-1 white--text mb-4 text-center">
            <a href="#/vip" class="white--text">Learn more</a>
          </h4>
        </v-col>
      </v-row>
    </v-row>
  </v-main>
</template>

<script>
export default {};
</script>

<style>
.gradiant {
  background: rgb(97, 97, 51);
  background: linear-gradient(
    90deg,
    rgba(97, 97, 51, 0) 0%,
    rgba(54, 33, 62, 0.7595413165266106) 31%,
    rgba(54, 33, 62, 0.7567401960784313) 61%,
    rgba(97, 97, 51, 0) 100%
  );
}
.bgimage {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
  background: url("../assets/1598971.jpg") no-repeat center center;
  background-size: cover;
  background-color:  #36213e;
}
</style>