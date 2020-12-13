<template>
        <v-row align="center" justify="center" class="mt-12">
          <v-alert
      :value="alert"
      v-model="alert"
      color="blue-grey"
      dark
      icon="mdi-account-alert"
      transition="scale-transition"
      dismissible
      outlined
      text
    >If you have an already created business profile, we recommend you to not add the same items again. Go to My Cards to view your existing business cards!
    </v-alert>
          <v-row>
          <v-col class="pa-0">
            <v-card flat tile class="gradiant pa-8 mx-8" max-width="1000px">
              <v-list-item-content class="fill-height white--text" align="center" justify="center">
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
</v-row>
<v-row>
          <v-col class="pa-0">
            <v-card flat tile class="pa-8 mx-8" max-width="1000px">
              <v-container fluid>
                <v-form>
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

                  <!-- ===============================================================Starting the items table=============================================================== -->

                  <v-data-table
                    :headers="headers"
                    :items="selectedItems"
                    no-data-text="Add your new items"
                    class="elevation-1 mb-8 yellow lighten-5"
                    hide-default-footer
                  >
                    <template v-slot:top>
                      <v-toolbar dense flat>
                        <v-toolbar-title>Items</v-toolbar-title>
                        <v-divider class="mx-4" inset vertical></v-divider>
                        <v-spacer></v-spacer>
                        <v-dialog v-model="dialog" max-width="800px">
                          <template v-slot:activator="{ on, attrs }">
                            <v-btn
                              color="yellow"
                              class="mb-2"
                              v-bind="attrs"
                              v-on="on"
                            >
                              New Item
                            </v-btn>
                          </template>
                          <v-card>
                            <v-card-title>
                              <span class="headline">{{ formTitle }}</span>
                            </v-card-title>

                            <v-card-text>
                              <v-container>
                                <v-row>
                                  <v-col cols="12" sm="6" md="4">
                                    <v-expansion-panels>
                                      <v-expansion-panel id="panel" expand>
                                        <v-expansion-panel-header>
                                          <v-row no-gutters>Select item</v-row>
                                        </v-expansion-panel-header>
                                        <v-expansion-panel-content class="overflow-y-auto" max-height="400px" style="overflow: hidden; height: 200px">
                                          <v-select
                                            v-model="editedItem.item"
                                            solo
                                            flat
                                            dense
                                            v-for="(okayhere, i) in categorisedItems"
                                            :key="i"
                                            :label="okayhere.cat"
                                            :items="okayhere.stuff"
                                          ></v-select>
                                        </v-expansion-panel-content> </v-expansion-panel
                                    ></v-expansion-panels>
                                  </v-col>
                                  <v-col cols="12" sm="6" md="4">
                                    <v-text-field
                                      v-model="editedItem.brand"
                                      label="Brand"
                                    ></v-text-field>
                                  </v-col>
                                  <v-col cols="12" sm="6" md="4">
                                    <v-text-field
                                      v-model="editedItem.deliverTo"
                                      label="Delivering to"
                                    ></v-text-field>
                                  </v-col>
                                  <v-col cols="12" sm="6" md="4">
                                    <v-text-field
                                      v-model="editedItem.price"
                                      label="Unit price"
                                    ></v-text-field>
                                  </v-col>
                                  <v-col cols="12" sm="6" md="4">
                                    <v-text-field
                                      v-model="editedItem.quanity"
                                      label="Quantity"
                                    ></v-text-field>
                                  </v-col>
                                </v-row>
                              </v-container>
                            </v-card-text>

                            <v-card-actions>
                              <v-spacer></v-spacer>
                              <v-btn color="blue darken-1" text @click="close">
                                Cancel
                              </v-btn>
                              <v-btn color="blue darken-1" text @click="save">
                                Save
                              </v-btn>
                            </v-card-actions>
                          </v-card>
                        </v-dialog>
                        <v-dialog v-model="dialogDelete" max-width="500px">
                          <v-card>
                            <v-card-title
                              >Are you sure you want to delete this
                              item?</v-card-title
                            >
                            <v-card-actions>
                              <v-spacer></v-spacer>
                              <v-btn
                                color="blue darken-1"
                                text
                                @click="closeDelete"
                                >Cancel</v-btn
                              >
                              <v-btn
                                color="blue darken-1"
                                text
                                @click="deleteItemConfirm"
                                >Delete</v-btn
                              >
                              <v-spacer></v-spacer>
                            </v-card-actions>
                          </v-card>
                        </v-dialog>
                      </v-toolbar>
                    </template>
                    <template v-slot:item.actions="{ item }">
                      <v-icon small class="mr-2" @click="editItem(item)">
                        mdi-pencil
                      </v-icon>
                      <v-icon small @click="deleteItem(item)">
                        mdi-delete
                      </v-icon>
                    </template>
                  </v-data-table>

                  <!-- ================================================================== table ends here ==================================================================== -->

                  <v-btn
                    @click.prevent="createProfile(personId)"
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
        </v-row>
</template>


<script>
import Axios from "axios";

export default {
  data() {
    return {
      //formCard: document.getElementById("formCard").clientHeight,
      type: "",
      location: "",
      mobile1: "",
      mobile2: "",
      landline: "",
      dataSet: [],              //dataSet of categories and items retrieved from the database(directly assigned from the mounted response)
      obj: {},                  //temporary object used to assign categories and items as objects and push to categorisedItems array   
      itemNames: [],            //temporary array used to assign items list of each category and push the categorisedItems array
      itemIds: [],
      personId: 0,              //logged in userId from the vuex store
      id: 0,                    //temporary id used to find and assign the ids of the items that are about to be posted to the database
      categorisedItems: [],     //List of categories, items and ids (from dataSet[]) as objects
      dialog: false,
      dialogDelete: false,
      headers: [
        {
          text: "Item",
          align: "start",
          sortable: false,
          value: "item",
        },
        { text: "Brand", value: "brand" },
        { text: "Delivering to", value: "deliverTo" },
        { text: "Unit Price", value: "price" },
        { text: "Quantity", value: "quanity" },
        { text: "Actions", value: "actions", sortable: false },
      ],
      selectedItems: [],
      editedIndex: -1,
      editedItem: {
        item: "",
        brand: "",
        deliverTo: "Any",
        price: "",
        quanity: 1,
      },
      defaultItem: {
        item: "",
        brand: "",
        deliverTo: "Any",
        price: "",
        quanity: 1,
      },
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
      alert: false,
    };
  },
  methods: {
    createProfile(personId) {
      console.log("when creating the profile, person id is " + personId)
      Axios.put("/person/" + personId, {
        type: this.type,
        address: this.location,
        mobile1: this.mobile1,
        mobile2: this.mobile2,
        landline: this.landline,
      })
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
        console.log("selected items are")
      console.log(this.selectedItems);

      for (let n = 0; n < this.selectedItems.length; n++) {                     //looping through the selected items and adding them to the itemperson table
        for (let i = 0; i < this.categorisedItems.length; i++) {
          for (let j = 0; j < this.categorisedItems[i].stuff.length; j++) {
            console.log(this.selectedItems[n].item +" "+ this.categorisedItems[i].stuff[j])
            if ((this.selectedItems[n].item) === this.categorisedItems[i].stuff[j]) {
              console.log("--------------------- WORKED!-------------------")
              this.id = this.categorisedItems[i].ids[j];
            } else {
              console.log("--------------------- Passed else -------------------")
            }
          }
        }
        Axios.post("/itemperson", {
          brand: this.selectedItems[n].brand,
          deliverTo: this.selectedItems[n].deliverTo,
          quantity: this.selectedItems[n].quanity,
          price: this.selectedItems[n].price,
           person: {
             id: this.personId},
           item: {
             id: this.id},
        }).then((response) => {
          console.log(response)
          })
          .catch((error) => {
            console.log(error);
          });
      }
      this.$router.replace({ name: "ItemPersonCards" });
    },

    initialize() {
      this.selectedItems = [];
    },
    editItem(item) {
      this.editedIndex = this.selectedItems.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },

    deleteItem(item) {
      this.editedIndex = this.selectedItems.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialogDelete = true;
    },

    deleteItemConfirm() {
      this.selectedItems.splice(this.editedIndex, 1);
      this.closeDelete();
    },

    close() {
      this.dialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    closeDelete() {
      this.dialogDelete = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    save() {
      if (this.editedIndex > -1) {
        Object.assign(this.selectedItems[this.editedIndex], this.editedItem);
      } else {
        this.selectedItems.push(this.editedItem);
      }
      this.close();
    },
  },

  mounted() {
    this.alert = true
    this.personId = this.$store.state.user.id
    console.log("user Id is " + this.personId)
    Axios.get("/categories")
      .then((response) => {

        this.dataSet = response.data;
        for (let i = 0; i < this.dataSet.length; i++) {
          for (let j = 0; j < this.dataSet[i].items.length; j++) {
            this.itemNames.push(this.dataSet[i].items[j].name);
            this.itemIds.push(this.dataSet[i].items[j].id);
          }
          this.obj.stuff = this.itemNames;
          this.itemNames = [];
          this.obj.ids = this.itemIds;
          this.itemIds = [];
          this.obj.cat = this.dataSet[i].name;
          this.$store.commit("setCategoryItems", this.obj)
          this.categorisedItems.push(this.obj);
          this.obj = {};
        }
        console.log("categorised items are ")
        console.log(this.$store.state.categoryItems)
      })
      .catch((e) => {
        console.log(e);
      });
  },
  computed: {
    formTitle() {
      return this.editedIndex === -1 ? "New Item" : "Edit Item";
    },
  },

  watch: {
    dialog(val) {
      val || this.close();
    },
    dialogDelete(val) {
      val || this.closeDelete();
    },
  },

  created() {
    this.initialize();
  },
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
