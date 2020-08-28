<template>
  <v-app id="inspire" class="blah">
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
                <v-form v-on:submit="signUp">
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
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn class="mr-6 mb-3 white--text" color="#554971" @click="postPerson">Signup</v-btn>
              </v-card-actions>
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
export default {
  props: {
    source: String,
  },

  data: () => ({
    all: null,
    email: '',
    password: '',

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

    postPerson: function (event) {
      if(this.email == '' || this.email == null){
        axios.post("api/person/all", {
          email: this.email,
        })
        .then(savedPerson => {
          this.all.push(savedPerson.data);
          this.email = '';
          this.password = '';
        })
      }else{
        axios.post("api/person/all", {
          "email": this.email,
          "password": this.password
        })
        .then(savedPerson => {
          this.email = '';
          this.password = '';
        })
      }
      console.log("record saved")
    }
  },
};



</script>
<style scoped>
  .blah{
    background-image: url( "../assets/square.jpg");
    background-size: cover;
  }
</style>