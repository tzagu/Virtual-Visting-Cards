<template>
  <v-app id="inspire" class="inspire">
    <v-main>
      <v-container class="fill-height inspire" fluid>
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
                    :rules="emailRules"
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

                  <v-btn
                    type="submit"
                    class="mr-6 mb-3 white--text"
                    color="#513B59"
                    >Login</v-btn
                  >
                </form>
              </v-card-text>
            </v-card>
            <div class="mt-8 grey--text">
              Not a member?
              <a href="/" class="white--text" @click="showSignUp"
                >Signup here</a
              >
            </div>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import Axios from "axios";
export default {
  data: () => ({
    email: "",
    password: "",
  }),
  methods: {
    login() {
      console.log("login method initiated");
      console.log(this.email);
      Axios.get("/partner/"+ this.email).then((response) => {
        console.log(response);
      });
    },
  },
};
</script>

<style scoped>
.inspire {
  background-color: #36213e;
}
</style>
