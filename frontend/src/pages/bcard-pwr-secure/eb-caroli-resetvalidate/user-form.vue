<template>
    <v-row align="center" justify="center">
    <v-col cols="12" sm="8" md="4">
      <v-card class="elevation-24">
        <v-toolbar color="#513B59" dark flat>
          <v-toolbar-title>Reset Password</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-tooltip bottom>
            <span>Source</span>
          </v-tooltip>
        </v-toolbar>
        <v-card-text>
          <form @submit.prevent="resetPassword">
            <v-text-field
              class="px-6 mt-6"
              v-model="email"
              prepend-icon="mdi-account"
              :rules="[
                (v) => !!v || 'E-mail is required',
                (v) => /.+@.+\..+/.test(v) || 'E-mail must be valid',
              ]"
              label="Enter your email"
              required
            ></v-text-field>

            <v-text-field
              v-model="password"
              class="px-6"
              id="password"
              label="Password"
              name="password"
              prepend-icon="mdi-lock"
              :append-icon="show3 ? 'mdi-eye' : 'mdi-eye-off'"
            :type="show3 ? 'text' : 'password'"
              @click:append="show3 = !show3"
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
            <v-btn type="submit" class="mr-6 mb-3 white--text" color="#513B59"
              >Reset</v-btn
            >
          </form>
        </v-card-text>
    </v-col>
        <v-snackbar
    :value="snackbar"
      v-model="snackbar"
      :timeout="timeout"
      shaped
      top
      color="red"
      transition="fab-transition"
    >
      {{ text }}
    </v-snackbar>
  </v-row>
</template>

<script>

import axios from 'axios'
export default {
  data() {
    return {
      show3: false,
      userId: 0,
      email: "",
      password: "",
      confirmpassword: "",
      snackbar: false,
      text: "",
      timeout: 5000,
    };
  },
  methods: {
    resetPassword() {
      axios.get("/partner/" + this.email).then((response) => {
        if (response.data != null) {
          if (response.data.email === this.email) {
            this.userId = response.data.id;
            axios
              .put("/resetpw/" + this.userId, {
                id: this.userId,
                password: this.confirmpassword,
              })
              .then((response) => {
                this.$swal("Successful! ", "Please login to continue", "success", {button: "Login"});
                console.log(response);
                this.$router.replace({name: "Login"})
              })
              .catch((error) => {
                console.log(error);
              });
          } else {
            this.text = "Unable to reset password. Please check your email address"
            this.snackbar = true
          }
        } else {
          this.text = "The email address is not registered in B Card platform"
          this.snackbar = true
        }
      });
    },
    passwords() {
      return this.confirmpassword === this.password || "passwords must match";
    },
  },
};
</script>

<style>
</style>