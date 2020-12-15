<template>
  <v-container fluid>
      <v-row>
          <v-col>
    <v-card class="pa-8">
      <v-row align="center" justify="center">
        <v-col>
          <v-select
            v-model="selectedCategory"
            :items="categories"
            label="Select category"
          ></v-select>
        </v-col>
      </v-row>

      <v-row>
        <v-col>
          <v-select
            v-model="selectedItems"
            multiple
            :items="items"
            label="Select required items"
          ></v-select>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <v-btn @click.prevent="saveItems">Save Big</v-btn>
        </v-col>
      </v-row>
    </v-card>
          </v-col>
          <v-col>
<v-card class="pa-8">
    <v-text-field v-model="selectedCategory" label="Type a category name"></v-text-field>
    <v-row>
        <v-col><v-text-field v-model="singleItem" label="Type item name"></v-text-field></v-col>
        <v-col><v-btn @click.prevent="addItemToList">Add</v-btn></v-col>
    </v-row>
    
    <v-text-field v-model="selectedItems" label="Your added items"></v-text-field>
<v-btn @click.prevent="saveItems">Save Small</v-btn>

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

  </v-container>
</template>

<script>
import Axios from "axios";
export default {
  data() {
    return {
          snackbar: false,
      text: "",
      timeout: 5000,
      selectedCategory: "",
      selectedItems: [],
      singleItem: "",
      tempObj: {}, //temp obj to create single item objects and add it to postingItems array
      postingItems: [],
      postingObject: {},

      categories: [
        "Surgical",
        "Electronic",
        "Fasion",
        "Cosmetics",
        "Art & Crafts",
        "Automobile",
        "Spices",
        "Food & Drinks",
        "Pharmaceutical",
        "Timber",
        "Households",
        "Sports",
        "Software and Related",
        "Health & Hygiene",
        "Real Estate",
        "Constructions",
      ],
      items: [
        "Masks",
        "Sanitizer",
        "Gloves",
        "Blades",
        "Isoprophyl alcohol",
        "Mobile phones",
        "Kitchenware",
        "Computer & Laptop",
        "Computer Hardware",
        "Outfits",
        "Clothing accessories",
        "Footwear",
        "Creams & Talcs",
        "Cleansing and Scrubs",
        "makeup",
        "Drawings",
        "Handcrafts",
        "Pain Items",
        "Vehicles",
        "Spare parts",
        "Accessories",
        "Spices",
        "Vegetables",
        "Fruits",
        "Snacks",
        "Frizzy",
        "Fresh Juice",
        "Bakery",
        "Other",
        "Tablets",
        "Syrups",
        "Furniture",
        "Crafts",
        "Constructional",
        "Cleaning material",
        "Utility",
        "Clothing",
        "Accessories",
        "Saas",
        "Appications",
        "Administration",
      ],
    };
  },
  methods: {
    saveItems() {
        this.postingObject.name = this.selectedCategory
        for(let i = 0; i < this.selectedItems.length; i++){
            this.tempObj.name = this.selectedItems[i]
            this.postingItems.push(this.tempObj)
            this.tempObj = {}
        }
        this.postingObject.items = this.postingItems
        console.log("posting object")
        console.log(this.postingObject)
      Axios.post("/savecategory", this.postingObject)
        .then((response) => {
          this.postingItems = []
          console.log(response);
          this.text = "Saved"
            this.snackbar = true
        })
        .catch((error) => {
          console.log(error);
        });
    },
    addItemToList(){
        this.selectedItems.push(this.singleItem)
    },
  },
};
</script>

<style>
</style>