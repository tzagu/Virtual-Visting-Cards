<template>
  <v-container>
    <v-row class="fill-height" align="center" justify="center">
      <v-col>
        <v-card min-width="150px" class="ma-2 pa-2">
          <v-card-title>
            #Categories
            <v-spacer></v-spacer>
            {{ categoryCount }}
          </v-card-title>
          <v-card-text>
            <v-select v-model="selectedCategory" :items="categories"></v-select>
          </v-card-text>
        </v-card>
        <v-card min-width="150px" class="ma-2 pa-2">
          <v-card-title>
            #Items
            <v-spacer></v-spacer>
            {{ itemCount }}
          </v-card-title>
          <v-card-text>
            <v-select
              v-model="selectedItems"
              :items="items"
              multiple
            ></v-select>
          </v-card-text>
        </v-card>
        <v-row>
          <v-col>
            <v-dialog v-model="deletebox">
              <template v-slot:activator="{ on, attrs }">
                <v-btn class="white--text" color="red" v-bind="attrs" v-on="on"
                  >Delete</v-btn
                ></template
              >
              <v-card class="pa-4">
                <v-row class="fill-height" align="center" justify="center">
                  <v-btn class="white--text ma-2" color="red" @click="deleteAll"
                    >Delete all</v-btn
                  >
                  <v-btn
                    class="white--text ma-2"
                    color="red"
                    @click="deleteItem"
                    >Delete item</v-btn
                  >
                </v-row>
              </v-card></v-dialog
            >
          </v-col>
          <v-col>
            <v-dialog v-model="edit">
              <template v-slot:activator="{ on, attrs }">
                <v-btn
                  class="white--text"
                  color="#36213e"
                  v-bind="attrs"
                  v-on="on"
                  >Edit</v-btn
                ></template
              >
              <v-card class="pa-4">
                <v-card-text>
                  <v-text-field
                    :value="selectedCategory"
                    placeholder="Select category"
                  ></v-text-field>
                  <v-text-field
                    v-model="selectedItems"
                    placeholder="Select item"
                  ></v-text-field>
                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn
                    class="white--text"
                    color="#36213e"
                    @click="saveChanges"
                    >Save changes</v-btn
                  >
                </v-card-actions>
              </v-card></v-dialog
            >
          </v-col>
          <v-col>
            <v-dialog v-model="add">
              <template v-slot:activator="{ on, attrs }">
                <v-btn
                  class="white--text"
                  color="#36213e"
                  v-bind="attrs"
                  v-on="on"
                  >New</v-btn
                ></template
              >
              <v-card class="pa-4">
                <v-card-text>
                  <v-text-field
                    v-model="newCategory"
                    placeholder="New category name"
                  ></v-text-field>
                  <v-text-field
                    v-model="newItems"
                    placeholder="New item name"
                  ></v-text-field>
                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn class="white--text" color="#36213e" @click="createNew"
                    >Create</v-btn
                  >
                </v-card-actions>
              </v-card></v-dialog
            >
          </v-col>
        </v-row>
      </v-col>
    </v-row>
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
  </v-container>
</template>

<script>
import Axios from "axios";
export default {
  data() {
    return {
      categoryCount: 0,
      selectedCategory: "",
      categories: [],
      itemCount: 0,
      selectedItems: [],
      EditedItems: [],
      items: [],
      edit: false, //edit category and item dialog box
      add: false, //add new category and item dialog box
      deletebox: false, //delete category &,OR item dialog box
      newCategory: "",
      newItems: "", //from the text field
      newItemsArr: [], //split from newItems
      postingObj: {},
      postingItems: [],
      tempObj: {},
      snackbar: false,
      text: "",
      timeout: 5000,
    };
  },
  methods: {
    saveChanges() {
      this.postingObj.name = this.selectedCategory;
      this.EditedItems = this.selectedItems.split(",");
      for (let i = 0; i < this.EditedItems.length; i++) {
        this.tempObj.name = this.EditedItems[i];
        this.postingItems.push(this.tempObj);
        this.tempObj = {};
      }
      this.postingObj.items = this.postingItems;
      this.postingItems = []

      Axios.put("/savecategorybyname/" + this.selectedCategory, {
        postingObj,
      })
        .then((response) => {
          this.postingObj = {}
          this.text = "saved!"
      this.snackbar = true
        })
        .catch((error) => {
          console.log(error);
        });
    },
    createNew() {
      this.postingObj.name = this.newCategory
      this.newItemsArr = this.newItems.split(",")
      for(let x = 0; x < this.newItemsArr.length; x++){
        this.tempObj.name = this.newItemsArr[x]
        this.postingItems.push(this.tempObj)
        this.tempObj = {}
      }
        this.postingObj.items = this.postingItems
        this.postingItems = []

        Axios.post("savecategory", {
          name: this.postingObj.name,
          items: this.postingObj.items
        }).then((response) => {
          this.postingObj = {}
          this.text = "Created!"
          this.snackbar = true
        }).catch((error) => {
          console.log(error)
        })
    },
    deleteAll() {
      this.text = "use postman tzagu!"
      this.snackbar = true
    },
    deleteItem() {
      this.text = "use postman tzagu!"
      this.snackbar = true
    },
  },
  mounted() {
    for (let i = 0; i < this.$store.state.categoryItems.length; i++) {
      this.categories.push(this.$store.state.categoryItems[i].cat);
      for (
        let j = 0;
        j < this.$store.state.categoryItems[i].stuff.length;
        j++
      ) {
        this.items.push(this.$store.state.categoryItems[i].stuff[j]);
      }
    }
    this.categoryCount = this.categories.length;
    this.itemCount = this.items.length;
  },
};
</script>

<style>
</style>