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
            <v-select v-model="selectedItem" :items="items"></v-select>
          </v-card-text>
        </v-card>
        <v-row>
          <v-col>
              <v-dialog v-model="deletebox">
              <template v-slot:activator="{ on, attrs }">
            <v-btn class="white--text" color="red" v-bind="attrs"
                  v-on="on">Delete</v-btn></template>
                  <v-card class="pa-4">
                      <v-row class="fill-height" align="center" justify="center">
                      <v-btn class="white--text ma-2" color="red" @click="deleteAll">Delete all</v-btn>
                      <v-btn class="white--text ma-2" color="red" @click="deleteItem">Delete item</v-btn>
                      </v-row>
                      </v-card></v-dialog>
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
                <v-text-field :value="selectedCategory" placeholder="Select category"></v-text-field>
                <v-text-field :value="selectedItem" placeholder="Select item"></v-text-field>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn class="white--text" color="#36213e" @click="saveChanges">Save changes</v-btn>
                </v-card-actions>
              </v-card></v-dialog
            >
          </v-col>
          <v-col>
              <v-dialog v-model="add">
              <template v-slot:activator="{ on, attrs }">
            <v-btn class="white--text" color="#36213e" v-bind="attrs"
                  v-on="on">New</v-btn></template
              >
              <v-card class="pa-4">
                  <v-card-text>
                <v-text-field v-model="newCategory" placeholder="New category name"></v-text-field>
                <v-text-field v-model="newItem" placeholder="New item name"></v-text-field>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn class="white--text" color="#36213e" @click="createNew">Create</v-btn>
                </v-card-actions>
              </v-card></v-dialog
            >
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      categoryCount: 137,
      selectedCategory: "",
      categories: ["cat 1", "cat 2", "cat 3", "cat 4", "cat 5"],
      itemCount: 5603,
      selectedItem: "",
      items: [
        "item 1",
        "item 2",
        "item 3",
        "item 4",
        "item 5",
        "item 6",
        "item 7",
      ],
      edit: false, //edit category and item dialog box
      add: false, //add new category and item dialog box
      deletebox: false, //delete category &,OR item dialog box
      newCategory: "",
      newItem: "",
    };
  },
  methods:{
    ///////////////////////    USE ADDITEMS COMPONENT METHODS WITHOUT WASTING TIME    !!!!!
      saveChanges(){},
      createNew(){},
      deleteAll(){},
      deleteItem(){},
  }
};
</script>

<style>
</style>