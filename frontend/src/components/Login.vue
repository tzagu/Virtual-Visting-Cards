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
          </form>
        </v-card-text>
      </v-card>
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
  }),
  methods: {
    login() {
      Axios.get("/partner/" + this.email)
        .then((response) => {
          if (
            this.email === response.data.email &&
            this.password === response.data.password
          ) {
            this.$store.commit("setName", response.data.name);
            this.$store.commit("setEmail", response.data.email);
            this.$store.commit("setUserId", response.data.id);
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
    this.$store.commit("setName", "");
    this.$store.commit("setEmail", "");
    this.$store.commit("setUserId", "");
  },
};
</script>

<style scoped>
.inspire {
  background-color: #36213e;
}
</style>
