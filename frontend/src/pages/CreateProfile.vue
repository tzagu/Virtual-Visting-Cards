<template>
  <v-app id="inspire" class="inspire">
    <v-main>
      <v-container class="fill-height inspire" fluid>
        <v-row align="center" justify="center">
          <v-col cols="4" class="pr-0">
            <v-card flat tile class="gradiant pa-8 ml-8">
              <v-list-item-content class="white--text">
                <v-list-item-title class="headline mb-1"
                  >Create your future!</v-list-item-title
                >
                <p>
                  Got a lot of ideas, but don't have the right people beside
                  you? We got your back! Create your profile today and find the
                  right business partner for you.
                </p>
              </v-list-item-content>
            </v-card>
          </v-col>

          <v-col cols="6" class="pl-0">
            <v-card flat tile class="pa-8 mr-8">
              <v-container fluid>
                <v-form>
                  <v-text-field v-model="name" label="Name"></v-text-field>
                  <v-row>
                    <v-col>
                      <v-text-field
                        readonly
                        label="Item"
                        v-model="selected"
                      ></v-text-field>
                    </v-col>
                    <v-col>
                      <v-expansion-panels>
                        <v-expansion-panel>
                          <v-expansion-panel-header>
                            <v-row no-gutters>Select</v-row>
                          </v-expansion-panel-header>
                          <v-expansion-panel-content>
                            <v-select
                              v-model="selected"
                              solo
                              flat
                              dense
                              multiple
                              v-for="(category, i) in categories"
                              :key="i"
                              :label="category.name"
                              :items="category.items"
                            ></v-select>
                          </v-expansion-panel-content> </v-expansion-panel
                      ></v-expansion-panels>
                    </v-col>
                  </v-row>
                  <v-select
                    label="Membership type"
                    :items="types"
                    v-model="type"
                  ></v-select>

                  <v-select
                    label="Location"
                    :items="districts"
                    v-model="location"
                  ></v-select>

                  <v-text-field
                    label="Mobile number 1"
                    v-model="mobile1"
                  ></v-text-field>

                  <v-text-field
                    label="Mobile number 2"
                    v-model="mobile2"
                  ></v-text-field>

                  <v-text-field
                    label="Home/Work number"
                    v-model="landline"
                  ></v-text-field>

                  <v-btn
                    @click="createProfile"
                    right
                    class="white--text"
                    color="#36213e"
                    >Create profile</v-btn
                  >
                </v-form>
              </v-container>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>


<script>
import Axios from "axios";

export default {
  data() {
    return {
      name: "",
      type: "",
      location: "",
      mobile1: "",
      mobile2: "",
      landline: "",

      selected: [],

      categories: [
        { name: "Cosmetics", items: ["cream", "talc"] },
        { name: "Pharmaceutical", items: ["masks", "gloves"] },
        { name: "Electronic", items: ["mobile phones"] },
        { name: "Automobile", items: [""] },
      ],

      stuff: [],

      types: ["Buyer", "Seller"],

      districts: [
        "Ampara",
        "Anuradhapura",
        "Badulla",
        "Batticaloa",
        "Colombo",
        "Galle",
        "Gampaha",
        "Hambantota",
        "Jaffna",
        "Kalutara",
        "Kandy",
        "Kegalle",
        "Kilinochchi",
        "Kurunegala",
        "Mannar",
        "Matale",
        "Matara",
        "Moneragala",
        "Mullaitivu",
        "Nuwara Eliya",
        "Polonnaruwa",
        "Puttalam",
        "Ratnapura",
        "Trincomalee",
        "Vavuniya",
      ],
    };
  },
  methods: {
    createProfile() {
      Axios.post("/saveperson", {
        name: this.name,
        type: this.type,
        location: this.location,
        mobile1: this.mobile1,
        mobile2: this.mobile2,
        landline: this.landline,
      })
        .then((response) => {
          console.log(response);
          this.$router.replace({ name: "ItemPersonCards" });
        })
        .catch((error) => {
          console.log(error);
        });
        console.log(this.selected)
    },
  },
  mounted(){
    Axios.get("/categories").then(response => {
      this.stuff = response.data
      console.log(this.stuff)
    })
  }
};
</script>


<style scoped>
.inspire {
  background-color: #36213e;
}
.gradiant {
  background: rgb(255, 252, 0);
  background: linear-gradient(
    45deg,
    rgba(255, 252, 0, 1) 0%,
    rgba(54, 33, 62, 1) 48%,
    rgba(255, 0, 121, 1) 100%
  );
}
</style>
