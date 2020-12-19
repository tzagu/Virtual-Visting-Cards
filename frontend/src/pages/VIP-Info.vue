<template>
  <v-container>
    <v-row class="fill-height" align="center" justify="center">
      <!-- <v-col cols="12" sm="8" md="4"> -->
      <v-sheet elevation="12" class="pa-6 vip" rounded>
        <v-row class="pt-2">
          <v-col class="text-center">
            <h1>VIP Tier</h1>
            <h3 class="mb-4">for premium members only</h3>

            <h3 class="text-left">Opportunities</h3>
            <ul class="text-left">
              <li>Auto generated profile ID</li>
              <p>
                Sharing a business card and asking your clients to call that
                number is no more the trend. B Card VIP issues you a unique QR
                code which anyone can scan and directly access your profile.
                This will also be automatically added to their saved cards
                lists.
              </p>
              <li>Select who can contact you</li>
              <p>
                Online business platforms can get stocked up with various
                fielders and newbies. While it is also important to allow anyone
                to test the waters and learn, You may only want to be contacted
                by premium members or the people who only deal with a specific
                item or a brand. premium members can explicitly set whom they
                would like be contacted by.
              </p>
              <li>Customize your cards</li>
              <p>
                If you are in the journey of building your brand or uplifting
                your existing brand, theming your profile can be a serious
                factor for you. Premium members can pick there card themes to
                match with their brands.
              </p>
              <li>Add custom items and descriptions</li>
              <p>
                Non-premium members can create cards only within the range of
                item selectives available. Premium members can add their unique
                products and create their own category to stand out from the
                crowd. Such products and categories will be added to the items
                list so that the general filtering will not cut off the cards
                rather highlight them in the list.
              </p>
              <li>Pin your cards to top</li>
              <p>
                Premium members can boost their marketing by pinning selected
                1-3 cards to top. If you have chosen to be contacted only by
                premium members, your pinned cards will only be visiblie to
                VIPs. This boosts will automatically expire in 12 months without
                prior notice. All pinned cards will be displayed in FIFO basis
                and the number of slots are currently limited to 24.
              </p>
              <li>View complete business profiles of cards</li>
              <p>
                Only premium members can view other cards posted by the same
                person of a selected card.
              </p>
              <li>Attend B Card VIP community conferences</li>
              <p>
                We, B Card platform hosts conferences annually, networking with
                top business profiles and sharing knowledge with a cup of
                coffee. Premium members has the opportunity to be selected as
                the new joiners, opening up many doors of immense value to learn
                from experts and grow your business.
              </p>
            </ul>

            <h3 class="text-left">
              To become a VIP, your must fulfill not less than 2(two) of the
              following requirements
            </h3>
            <ul class="text-left">
              <li>
                Has been an <u @click="active">active</u> B Card user for more
                than 12 months
              </li>
              <li>
                Successfully <u @click="contacted()">contacted</u> more than 24 different partners through B Card
                platform
              </li>
              <li>
                Has been <u @click="contacted()">contacted</u> by more than 16 different partners through your
                existing B cards
              </li>
              <li>
                Successfully registered to B Card VIP
                <u @click="fee">subscription</u>
              </li>
              <li>
                Has had 5 star rating on one of your cards for concecutive 8
                months
              </li>
            </ul>
          </v-col>
        </v-row>
      </v-sheet>
      <!-- </v-col> -->
    </v-row>
  </v-container>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {
    active() {
      this.$swal(
        "active:",
        "Minimum of 5(five) platform visits each month and has added not less than 1(one) business card during the considered 12 months",
        { buttons: false }
      );
    },
    fee() {
      this.$swal(
        "subscription:",
        "You can get a VIP subscription as a wild card by paying $45 along with having met one of the other requirements listed",
        { buttons: false }
      );
    },
    contacted(){
        this.$swal("contacted:", "Contacted via E-MAIL through B Card platform.", {buttons: false})
    }
  },
};
</script>

<style>
.vip {
  font-family: serif;
}
</style>