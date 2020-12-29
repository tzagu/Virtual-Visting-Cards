<template>
  <v-row align="center" justify="center">
    <v-col cols="12" sm="8" md="4">
      <v-card class="elevation-24">
        <v-toolbar color="#36213e" dark flat>
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
              :rules="[
                (v) => !!v || 'E-mail is required',
                (v) => /.+@.+\..+/.test(v) || 'E-mail must be valid',
              ]"
              label="E-mail"
              required
            ></v-text-field>

            <v-text-field
              :append-icon="show3 ? 'mdi-eye' : 'mdi-eye-off'"
              :type="show3 ? 'text' : 'password'"
              @click:append="show3 = !show3"
              v-model="password"
              class="px-6"
              id="password"
              label="Password"
              name="password"
              prepend-icon="mdi-lock"
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
              required
            >
              <template v-slot:label>
                <div>
                  I have read, consent and agree to the B Card
                  <v-tooltip bottom>
                    <template v-slot:activator="{ on }">
                      <a
                      class="grey--text"
                        target="_blank"
                        href="#/useragreement"
                        @click.stop
                        v-on="on"
                      >
                        User agreement
                      </a>
                    </template>
                    Read terms and conditions
                  </v-tooltip>
                  and 
                  <v-tooltip bottom>
                    <template v-slot:activator="{ on }">
                      <a
                      class="grey--text"
                        target="_blank"
                        href="#/privacypolicy"
                        @click.stop
                        v-on="on"
                      >
                        Privacy policy
                      </a>
                    </template>
                    Read privacy policy
                  </v-tooltip>
                </div>
              </template>
            </v-checkbox>
            <v-btn
              type="submit"
              @click="validate"
              class="mr-6 mb-3 white--text"
              color="#36213e"
              >Signup</v-btn
            >
            <!-- <div id="google-signin-button"></div> -->
          </v-form>
        </v-card-text>
      </v-card>
      <!-- <v-row>
        <div class="mt-8 mr-10 grey--text">Signup with google </div>
        <div class="mt-8" id="google-signin-button"></div>
      </v-row> -->
      <div class="mt-8 grey--text">
        Already have and account?
        <a href="#/login" class="white--text">Login</a>
      </div>
      <div></div>
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
    show3: false,
    email: "",
    password: "",
    confirmpassword: "",
    name: "",
    checkbox: false,
    activity: "Signup",
    addActivity: {}
  }),

  methods: {
    // onSignIn(googleUser) {
    //   const profile = googleUser.getBasicProfile();
    //   this.name = profile.getName();
    //   this.email = profile.getEmail();

    //   axios.get("/partner/" + this.email).then((response) => {
    //     if (response.data === "") {
    //       axios
    //         .post("/saveperson", {
    //           email: this.email,
    //           name: this.name,
    //         })
    //         .then((response) => {
    //           console.log(response);
    //           this.$store.commit("setUser", response.data);
    //           this.$router.push({ name: "ItemPersonCards" });
    //         })
    //         .catch((error) => {
    //           console.log(error);
    //         });
    //     } else {
    //       alert(
    //         "A user from this email already exists. Please sign in or use a different email address."
    //       );
    //       document.getElementById("email").focus();
    //     }
    //   });
    // },
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
        axios.get("/partner/" + this.email).then((response) => {
          if (response.data === "") {
            axios
              .post("/saveperson", {
                email: this.email,
                password: this.password,
                name: this.name,
              })
              .then((response) => {
                let personId = response.data.id
                this.addActivity.personId = personId,
                this.addActivity.activity = this.activity,
                this.addActivity.email = this.email,
                axios.post("/addactivity", this.addActivity).catch((error) => {
                  console.log(error)
                })
                this.$swal({ icon: "success", timer: 3000 });
                this.$router.push({ name: "Login" });
              })
              .catch((error) => {
                console.log(error);
              });
          } else {
            this.text =
              "A user from this email already exists. Please use a different email address.";
            this.snackbar = true;
            document.getElementById("email").focus();
          }
        });
      }
    },
  },
  mounted() {
    // gapi.signin2.render("google-signin-button", {
    //   onsuccess: this.onSignIn,
    // });
    sessionStorage.clear();
  },
};
</script>


<style scoped>
.inspire {
  background-color: #36213e;
  background: #36213e;
}
</style>
