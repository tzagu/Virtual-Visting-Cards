<template>
  <v-row align="center" justify="center">
    <v-col cols="12" sm="8" md="4">
      <v-card class="elevation-24">
        <v-toolbar color="#513B59" dark flat>
          <v-toolbar-title>Edit personal profile</v-toolbar-title>
          <v-spacer></v-spacer>
        </v-toolbar>
        <v-card-text>
          <form @submit.prevent="updateProfile(id)">

            <v-text-field
            disabled
              v-model="email"
              class="px-6 mt-6"
              label="Email"
              :value="email"
            ></v-text-field>

            <v-text-field
              class="px-6 mt-6"
              v-model="name"
              :value="name"
              :rules="[(v) => !!v || 'Name is required']"
              label="Name"
              required
            ></v-text-field>

            <v-text-field
              v-model="location"
              class="px-6 mt-6"
              label="Location"
              :value="location"
              :rules="[(v) => !!v || 'Location is required']"
            ></v-text-field>

            <v-text-field
              v-model="mobile1"
              class="px-6 mt-6"
              label="Mobile 1"
              :value="mobile1"
              :rules="[(v) => !!v || 'Mobile number is required']"
            ></v-text-field>

            <v-text-field
              v-model="mobile2"
              class="px-6 mt-6"
              label="Mobile 2"
              :value="mobile2"
            ></v-text-field>

            <v-text-field
              v-model="landLine"
              class="px-6 mt-6"
              label="Work number"
              :value="landLine"
            ></v-text-field>
            <v-card-actions>
<v-row>

            <v-btn type="submit" class="ml-6 mb-3 white--text" color="#513B59"
              >Save</v-btn
            >
            <v-spacer></v-spacer>

            <v-btn @click="showHomePage" class="mr-6 mb-3 white--text" color="#513B59"
              >Back</v-btn
            >
</v-row>
</v-card-actions>
            <div>
              Go to <a href="#/mydeals">My Cards</a> to alter your existing
              business cards
            </div>
          </form>
        </v-card-text>
      </v-card>
    </v-col>
    <v-snackbar
    :value="snackbar"
      v-model="snackbar"
      :timeout="timeout"
      shaped
      top
      color="green"
      transition="fab-transition"
    >
      {{ text }}
    </v-snackbar>
  </v-row>
</template>

<script>
export default {
  data() {
    return {
      id: 0,
      email: "",
      name: "",
      location: "",
      mobile1: "",
      mobile2: "",
      landline: "",
          snackbar: false,
      text: "",
      timeout: 5000,
    };
  },
  methods: {
    updateProfile(id) {
      Axios.put("/person/" + id, {
        name: this.name,
        address: this.location,
        mobile1: this.mobile1,
        mobile2: this.mobile2,
        landline: this.landline,
      })
        .then((response) => {
          console.log(response);
          this.text = "Saved!"
            this.snackbar = true
        })
        .catch((error) => {
          console.log(error);
        });
    },
    showHomePage(){
      this.$router.push({name: "ItemPersonCards"})
    },
  },
  mounted(){
this.id = this.$store.state.user.id
    this.email = this.$store.state.user.email
      this.name = this.$store.state.user.name
      this.location = this.$store.state.user.address
      this.mobile1 = this.$store.state.user.mobile1
      this.mobile2 = this.$store.state.user.mobile2
      this.landline = this.$store.state.user.landline
  }
};
</script>

<style>
</style>