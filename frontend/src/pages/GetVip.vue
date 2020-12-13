<template>
  <v-main class="bgimage" style="padding: 0px 0px 0px">
    <v-row class="fill-height" align="center" justify="center">
      <v-row>
        <v-col class="text-center gradiant" cols="12">
          <h1 class="mb-4 white--text">VIP B Cards</h1>
          <h3 class="subheading white--text">
            Great Day {{ this.$store.state.user.name }} !
          </h3>
          <h4 class="subtitle-1 white--text mb-4">
            You are currently not eligible for this tier
          </h4>
          <h4 class="subtitle-1 white--text mb-4">
            You must fullfil two or more of the following conditions to be a VIP
            user
          </h4>
          <h4 class="overline white--text">
            <ul>
              <li>Has been an active B Card user for more than 12 months</li>
              <li>
                Successfully contacted more than 6 partners through B Card
                platform
              </li>
              <li>
                Has been contacted by more than 12 partners through your
                existing B cards
              </li>
              <li>Successfully registered to B Card VIP subscription</li>
              <li>
                Has had 5 star rating on one of your cards for concecutive 5
                months
              </li>
            </ul>
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
  background-color: red;
}
</style>