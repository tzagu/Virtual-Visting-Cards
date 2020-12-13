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
          <form @submit.prevent="requestReset">
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
            <v-btn type="submit" class="mr-6 mb-3 white--text" color="#513B59"
              >Send password reset link</v-btn
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
      color="blue-grey"
      transition="fab-transition"
    >
      {{ text }}
    </v-snackbar>
  </v-row>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      email: "",
      message:
        "Hi, \n You have requested to reset the password to your B Card account. Please click the link below to accept and reset the password. \n http://localhost:8080/#/bcard-pwr-secure/eb-caroli-resetvalidate/user-form",
        snackbar: false,
      text: "Password reset link sent to your email !",
      timeout: 5000,
    };
  },
  methods: {
    requestReset() {
      axios.post("/contactpartner", {
        to: this.email,
        subject: "B Card Password Reset",
        text: this.message,
      }).catch((error) => {
        console.log(error);
      });
      this.snackbar = true
    },
  },
};
</script>

<style>
</style>