<template>
  <v-app id="inspire">
    <v-main>
      <v-container class="fill-height" fluid>
        <v-row align="center" justify="center">
          <v-col cols="12" sm="8" md="4">
            <v-card class="elevation-24">
              <v-toolbar color="#554971" dark flat>
                <v-toolbar-title>Signup</v-toolbar-title>
                <v-spacer></v-spacer>
                <v-tooltip bottom>
                  <span>Source</span>
                </v-tooltip>
              </v-toolbar>
              <v-card-text>
                <form @submit.prevent="signUp">
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
                    class="px-6"
                    id="password"
                    label="Password"
                    name="password"
                    prepend-icon="mdi-lock"
                    type="password"
                  ></v-text-field>

                  <v-text-field
                    class="px-6"
                    id="confirmpassword"
                    label="Confirm Password"
                    name="confirmpassword"
                    prepend-icon="mdi-lock"
                    type="password"
                  ></v-text-field>

                  <v-checkbox
                    class="px-6"
                    v-model="checkbox"
                    :rules="[v => !!v || 'You must agree to continue!']"
                    label="Agree to terms and conditions"
                    required
                  ></v-checkbox>
                  <v-btn type="submit" class="mr-6 mb-3 white--text" color="#554971">Signup</v-btn>
                </form>
              </v-card-text>
            </v-card>
            <div class="mt-8">
              Already have and account?
              <a href="#" class="text-decoration-none">Login</a>
            </div>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>


<script>
import axios from 'axios'

export default {
  props: {
    source: String,
  },

  data: () => ({
    email: "",
    password: "",

    emailRules: [
      (v) => !!v || "E-mail is required",
      (v) => /.+@.+\..+/.test(v) || "E-mail must be valid",
    ],
    checkbox: false,
  }),

  // mounted(){
  //   this.findAll();
  // },

  methods: {
    validate() {
      this.$refs.form.validate();
    },

    // signUp: function (event) {
    //   if(this.email == '' || this.email == null){
    //     this.$axios.post("api/person/all", {
    //       email: this.email,
    //     })
    //     .then(savedPerson => {
    //       this.all.push(savedPerson.data);
    //       this.email = '';
    //       this.password = '';
    //     })
    //   }else{
    //     this.$axios.post("api/person/all", {
    //       "email": this.email,
    //       "password": this.password
    //     })
    //     .then(savedPerson => {
    //       this.email = '';
    //       this.password = '';
    //     })
    //   }
    //   console.log("record saved")
    // }

    signUp() {
      console.log(
        "welcome to the one and only business platform in sri lanka"
      );
      axios
        .post('/saveperson', {
          email: this.email,
          password: this.password,
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
</style>
