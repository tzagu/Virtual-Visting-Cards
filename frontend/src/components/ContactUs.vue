<template>
        <v-row align="center" justify="center">

          <v-card class="pa-8">
            <p>Give us a shout! Your opinion is appreciated</p>
            <p>Need to contact? Send us a message</p>
          </v-card>

          <v-card class="pa-8">
              <v-form>
                  <v-text-field
                    prepend-icon="mdi-account"
                    label="Name"
                    required
                  ></v-text-field>
                  <v-text-field
                    prepend-icon="mdi-email"
                    label="Your email"
                    required
                  ></v-text-field>
                  <v-textarea label="Message" prepend-icon="mdi-message"></v-textarea>
              </v-form>
          </v-card>

        </v-row>
</template>

<script>
export default {};
</script>

<style scoped>

.inspire{
    background-color: #36213E;}
</style>    