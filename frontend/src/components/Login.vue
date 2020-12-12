<template>
  <v-row align="center" justify="center">
    <v-col cols="12" sm="8" md="4">
      <v-card class="elevation-24">
        <v-toolbar color="#513B59" dark flat>
          <v-toolbar-title>Login</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-tooltip bottom>
            <span>Source</span>
          </v-tooltip>
        </v-toolbar>
        <v-card-text>
          <form @submit.prevent="login">
            <v-text-field
              class="px-6 mt-6"
              v-model="email"
              prepend-icon="mdi-account"
              :rules="[
                (v) => !!v || 'E-mail is required',
                (v) => /.+@.+\..+/.test(v) || 'E-mail must be valid',
              ]"
              label="E-mail"
              required
            ></v-text-field>

            <v-text-field
              v-model="password"
              class="px-6 mt-6"
              id="password"
              label="Password"
              name="password"
              prepend-icon="mdi-lock"
              type="password"
            ></v-text-field>

            <v-btn type="submit" class="mr-6 mb-3 white--text" color="#513B59"
              >Login</v-btn
            >
            <!-- <div id="google-signin-button"></div> -->
          </form>
        </v-card-text>
      </v-card>
            <v-row>
        <div class="mt-8 mr-10 grey--text">Sign in with google</div>
        <div class="mt-8" id="google-signin-button"></div>
      </v-row>
      <div class="mt-8 grey--text">
        Not a member?
        <a href="/" class="white--text">Signup here</a>
        <!-- showSignupPage method should be added to render the page instead of giving a link path -->
      </div>
    </v-col>
  </v-row>
</template>

<script>
import Axios from "axios";
import ItemPersonCards from "./ItemPersonCards";
export default {
  props: {
    source: String,
  },
  components: {
    ItemPersonCards,
  },

  data: () => ({
    email: "",
    password: "",
    name: ""
  }),
  methods: {
    onSignIn(googleUser) {
      const profile = googleUser.getBasicProfile();
      this.name = profile.getName();
      this.email = profile.getEmail();
      console.log("this.email")
      console.log(this.email)

      Axios.get("/partner/" + this.email)
        .then((response) => {
          console.log(response.data.email)
          if (
            this.email === response.data.email
          ) {
            this.$store.commit("setUser", response.data);
            this.$router.push({ name: "ItemPersonCards" });
          } else {
            alert("The credentials doesn't match. Please try again");
          }
        })
        .catch((error) => {
          console.log(error);
        });

    },
    login() {
      Axios.get("/partner/" + this.email)
        .then((response) => {
          if (
            this.email === response.data.email &&
            this.password === response.data.password
          ) {
            this.$store.commit("setUser", response.data);
            this.$router.push({ name: "ItemPersonCards" });
          } else {
            alert("The credentials doesn't match. Please try again");
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  mounted() {
    gapi.signin2.render('google-signin-button', {
      onsuccess: this.onSignIn
    })
    sessionStorage.clear();
    //this.$store.commit("setUser", null);
  },
};
</script>

<style scoped>
.inspire {
  background-color: #36213e;
}
</style>
