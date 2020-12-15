<template>
  <v-row align="center" justify="center" class="fill-height">
    <v-card class="pa-6">
      <p>Give us a shout! Your opinion is appreciated</p>
      <p>Need to contact? Send us a message</p>
    </v-card>

    <v-card class="pa-8">
      <v-form>
        <v-text-field
          prepend-icon="mdi-account"
          label="Name"
          required
          :value="senderName"
          disabled
        ></v-text-field>
        <v-text-field
          prepend-icon="mdi-email"
          label="Your email"
          required
          :value="senderEmail"
          disabled
        ></v-text-field>
        <v-textarea
          v-model="message"
          label="Message"
          prepend-icon="mdi-message"
        ></v-textarea>
      </v-form>
      <v-card-actions>
        <v-btn @click.prevent="contactUs" color="#36213e" class="white--text"> Send </v-btn>
      </v-card-actions>
    </v-card>
  </v-row>
</template>

<script>
import Axios from "axios"

export default {
  data() {
    return {
      senderName: "",
      senderEmail: "",
      message: "",
    };
  },
  mounted() {
    this.senderName = this.$store.state.user.name;
    this.senderEmail = this.$store.state.user.email;
  },
  methods: {
    contactUs() {
      this.$swal("Sent! ", "Thank you for contacting us", "success", {button: "Done"});
      Axios.post("/contactpartner", {
        to: "linetcoservices@gmail.com",
        replyTo: this.senderEmail,
        subject: "Sent via Contact Us",
        text: this.message,
      })
        .catch((error) => {
          console.log(error);
        });
        this.$router.push({name: "ItemPersonCards"})
    },
  },
};
</script>

<style scoped>
.inspire {
  background-color: #36213e;
}
</style>    