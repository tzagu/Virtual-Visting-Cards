webpackJsonp([1],{"7zck":function(t,e){},BmOx:function(t,e){},KAbA:function(t,e){},NHnr:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=n("7+uW"),s={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{attrs:{id:"app"}},[e("router-view")],1)},staticRenderFns:[]};var o=n("VU/8")({name:"App"},s,!1,function(t){n("gsu9")},null,null).exports,r=n("/ocq"),i={render:function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"hello"})},staticRenderFns:[]};var l=n("VU/8")({name:"HelloWorld",data:function(){return{msg:"Welcome to Your Vue.js App"}}},i,!1,function(t){n("KAbA")},"data-v-8e3663e8",null).exports,c=n("mtWM"),u=n.n(c),p={props:{source:String},data:function(){return{email:"",password:"",emailRules:[function(t){return!!t||"E-mail is required"},function(t){return/.+@.+\..+/.test(t)||"E-mail must be valid"}],checkbox:!1}},methods:{validate:function(){this.$refs.form.validate()},signUp:function(){console.log("welcome to the one and only business platform in sri lanka"),u.a.post("",{email:this.email,password:this.password}).then(function(t){console.log(t)}).catch(function(t){console.log(t)})}}},d={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-app",{attrs:{id:"inspire"}},[n("v-main",[n("v-container",{staticClass:"fill-height",attrs:{fluid:""}},[n("v-row",{attrs:{align:"center",justify:"center"}},[n("v-col",{attrs:{cols:"12",sm:"8",md:"4"}},[n("v-card",{staticClass:"elevation-24"},[n("v-toolbar",{attrs:{color:"#554971",dark:"",flat:""}},[n("v-toolbar-title",[t._v("Signup")]),t._v(" "),n("v-spacer"),t._v(" "),n("v-tooltip",{attrs:{bottom:""}},[n("span",[t._v("Source")])])],1),t._v(" "),n("v-card-text",[n("form",{on:{submit:function(e){return e.preventDefault(),t.signUp(e)}}},[n("v-text-field",{staticClass:"px-6 mt-6",attrs:{"prepend-icon":"mdi-account",rules:t.emailRules,label:"E-mail",required:""},model:{value:t.email,callback:function(e){t.email=e},expression:"email"}}),t._v(" "),n("v-text-field",{staticClass:"px-6",attrs:{id:"password",label:"Password",name:"password","prepend-icon":"mdi-lock",type:"password"},model:{value:t.password,callback:function(e){t.password=e},expression:"password"}}),t._v(" "),n("v-text-field",{staticClass:"px-6",attrs:{id:"confirmpassword",label:"Confirm Password",name:"confirmpassword","prepend-icon":"mdi-lock",type:"password"}}),t._v(" "),n("v-checkbox",{staticClass:"px-6",attrs:{rules:[function(t){return!!t||"You must agree to continue!"}],label:"Agree to terms and conditions",required:""},model:{value:t.checkbox,callback:function(e){t.checkbox=e},expression:"checkbox"}}),t._v(" "),n("v-btn",{staticClass:"mr-6 mb-3 white--text",attrs:{type:"submit",color:"#554971"}},[t._v("Signup")])],1)])],1),t._v(" "),n("div",{staticClass:"mt-8"},[t._v("\n            Already have and account?\n            "),n("a",{staticClass:"text-decoration-none",attrs:{href:"#"}},[t._v("Login")])])],1)],1)],1)],1)],1)},staticRenderFns:[]};var m=n("VU/8")(p,d,!1,function(t){n("BmOx")},"data-v-f22195b4",null).exports;a.default.use(r.a);var v=new r.a({routes:[{path:"/signup",name:"HelloWorld",component:l},{path:"/",name:"SignUp",component:m}]}),f=n("3EgV"),b=n.n(f);n("7zck");a.default.use(b.a);var h=new b.a({});a.default.config.productionTip=!1,new a.default({el:"#app",router:v,vuetify:h,components:{App:o},template:"<App/>"})},gsu9:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.62a16d88e4ae9a86b657.js.map