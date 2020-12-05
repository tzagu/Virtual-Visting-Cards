<template>
  <v-app-bar dark dense color="#36213E" class="my-4" flat absolute fixed app>
    <v-btn @click.prevent="showItemPersonCards" icon>
      <v-icon>mdi-home-outline</v-icon>
    </v-btn>

    <v-spacer></v-spacer>

  <v-tooltip bottom>
      <template v-slot:activator="{ on, attrs }">
    <v-btn @click.prevent="showFilter" icon v-bind="attrs"
          v-on="on">
      <v-icon>mdi-tune</v-icon>
    </v-btn>
    </template>
      <span>Filter</span>
    </v-tooltip>

        <v-menu left bottom>
      <template v-slot:activator="{ on, attrs }">
        <v-btn v-bind="attrs" v-on="on" icon>
          <v-icon>mdi-account-outline</v-icon>
        </v-btn>
      </template>
      <v-list>
        <v-list-item
          v-for="(profile, index) in profile"
          :key="index"
          @click="(showProfileActivities(profile.pageName))"
        >
        <v-list-item-icon>
          <v-icon v-text="profile.icon"></v-icon>
        </v-list-item-icon>
          <v-list-item-title>
            {{ profile.title }}
          </v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>

    <v-menu left bottom>
      <template v-slot:activator="{ on, attrs }">
        <v-btn v-bind="attrs" v-on="on" icon>
          <v-icon>mdi-dots-vertical</v-icon>
        </v-btn>
      </template>
      <v-list>
        <v-list-item
          v-for="(options, index) in options"
          :key="index"
          @click="(activateOption(options.pageName))"
        >
        <v-list-item-icon>
          <v-icon v-text="options.icon"></v-icon>
        </v-list-item-icon>
          <v-list-item-title>
            {{ options.title }}
          </v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </v-app-bar>
</template>

<script>
export default {
  data() {
    return {
      options: [
        { icon : "mdi-crown", title: "Become VIP", pageName: "GetVip" },
        { icon : "mdi-account-card-details", title: "Create business profile", pageName: "CreateProfile" },
        { icon : "mdi-comment-account", title: "Contact us", pageName: "ContactUs" },
        { icon : "mdi-rocket", title: "Take a tour", pageName: "Tour" },
      ],
      profile: [
        {icon : "mdi-account-settings-variant", title: "My cards", pageName: "MyDeals"},
        {icon : "mdi-emoticon-sad", title: "Logout", pageName: "Login"}
      ]
    };
  },

  methods: {
    activateOption(pageName) {
      console.log("method invoked");
      console.log(pageName);
      this.$router.push({ name: pageName });
    },
    showItemPersonCards() {
      this.$store.commit("setFilterStatus", false);
      this.$router.push({ name: "ItemPersonCards" });
      // window.location.reload();
    },
    showFilter() {
      this.$router.push({ name: "Filter" });
    },
    showProfileActivities(pageName) {
      this.$router.push({ name: pageName });
    },
    showOptions() {
      this.$router.push({ name: "ContactUs" });
    },
  },
};
</script>

<style>
</style>