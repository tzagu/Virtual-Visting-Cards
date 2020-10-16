<template>
  <v-app id="inspire" class="inspire">
    <v-main>
      <v-container class="fill-height inspire" fluid>
        <v-row align="center" justify="center">
          <v-col cols="12" sm="8" md="4">
            <v-card class="elevation-24">
              <v-toolbar color="#513B59" dark flat>
                <v-toolbar-title>Signup</v-toolbar-title>
                <v-spacer></v-spacer>
                <v-tooltip bottom>
                  <span>Source</span>
                </v-tooltip>
              </v-toolbar>
              <v-card-text>
                <form @submit.prevent="signUp">
                  <v-text-field
                  v-model="name"
                  id="name"
                  name="name"
                    class="px-6 mt-8"
                    prepend-icon="mdi-account"
                    label="Username"
                    required
                  ></v-text-field>

                  <v-text-field
                    class="px-6 mt-1"
                    v-model="email"
                    prepend-icon="mdi-email"
                    :rules="emailRules"
                    label="E-mail"
                    required
                  ></v-text-field>


                  <v-text-field
                    v-model="password"
                    class="px-6"
                    id="password"
                    label="Password"
                    name="password"
                    prepend-icon="mdi-lock"
                    type="password"
                  ></v-text-field>

                  <v-text-field
                  v-model="confirmpassword"
                    class="px-6"
                    :rules="[passwords]"
                    id="confirmpassword"
                    label="Confirm Password"
                    name="confirmpassword"
                    prepend-icon="mdi-lock-check"
                    type="password"
                  ></v-text-field>

                  <v-checkbox
                    class="px-6"
                    v-model="checkbox"
                    :rules="[v => !!v || 'You must agree to continue!']"
                    label="Agree to terms and conditions"
                    required
                  ></v-checkbox>
                  <v-btn type="submit" class="mr-6 mb-3 white--text" color="#513B59">Signup</v-btn>
                </form>
              </v-card-text>
            </v-card>
            <div class="mt-8 grey--text">
              Already have and account?
              <a href="#/login"  class="white--text">Login</a>
            </div>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>


<script>
import axios from 'axios'
import Login from './Login'

export default {
  props: {
    source: String,
  },
  components: {
    Login
  },

  data: () => ({
    email: "",
    password: "",
    confirmpassword: "",
    name: "",

    emailRules: [
      (v) => !!v || "E-mail is required",
      (v) => /.+@.+\..+/.test(v) || "E-mail must be valid",
    ],
    pwrules: [
      passwords
    ],
    checkbox: false,
  }),

  methods: {
    validate() {
      this.$refs.form.validate();
    },

    passwords() {
      return this.confirmpassword === this.password || "passwords must match";
    },

    signUp() {
      console.log(
        "signup method initiated"
      );
      axios
        .post('/saveperson', {
          email: this.email,
          password: this.password,
          name: this.name
        })
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>


<style scoped>

.inspire{
    background-color: #36213E;
    background: #36213E;
    }
</style>
