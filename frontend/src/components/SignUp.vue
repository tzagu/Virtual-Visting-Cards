<template>
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
                <v-form ref="form" @submit.prevent="signUp">
                  <v-text-field
                    v-model="name"
                    id="name"
                    name="name"
                    class="px-6 mt-8"
                    prepend-icon="mdi-account"
                    label="Username"
                    counter="20"
                    :rules="[maxLength]"
                    required
                  ></v-text-field>

                  <v-text-field
                  id="email"
                  type="email"
                    class="px-6 mt-1"
                    v-model="email"
                    prepend-icon="mdi-email"
                    :rules="[(v) => !!v || 'E-mail is required', (v) => /.+@.+\..+/.test(v) || 'E-mail must be valid']"
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
                    :rules="[(v) => !!v || 'You must agree to continue!']"
                    label="Agree to terms and conditions"
                    required
                  ></v-checkbox>
                  <v-btn
                    type="submit"
                    @click="validate"
                    class="mr-6 mb-3 white--text"
                    color="#513B59"
                    >Signup</v-btn
                  >
                </v-form>
              </v-card-text>
            </v-card>
            <div class="mt-8 grey--text">
              Already have and account?
              <a href="#/login" class="white--text">Login</a>
            </div>
          </v-col>
        </v-row>
</template>


<script>
import axios from "axios";
import Login from "./Login";

export default {
  props: {
    source: String,
  },
  components: {
    Login,
  },

  data: () => ({
    email: "",
    password: "",
    confirmpassword: "",
    name: "",

    checkbox: false,
  }),

  methods: {
    validate() {
      this.$refs.form.validate();
    },

    maxLength() {
      return (
        this.name.length <= 20 || "username should be less than 20 characters"
      );
    },

    passwords() {
      return this.confirmpassword === this.password || "passwords must match";
    },

    signUp() {
      if (this.$refs.form.validate()) {
        axios.get("/partner/"+this.email).then(
          response => {
            if(response.data === ""){
              axios
                .post("/saveperson", {
                  email: this.email,
                  password: this.password,
                  name: this.name,
                })
                .then((response) => {
                  console.log(response);
                  this.$router.push({ name: "Login" });
                })
                .catch((error) => {
                  console.log(error);
                });
            }
            else{
              alert("A user from this email already exists. Please use a different email address.")
              document.getElementById("email").focus()
            }
          }
        );
      }
    },
  },
};
</script>


<style scoped>
.inspire {
  background-color: #36213e;
  background: #36213e;
}
</style>
