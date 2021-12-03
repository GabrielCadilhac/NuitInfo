
var app = new Vue({
  el: "#app",
  data: {
    value_recherche: ""
  },
  methods: {
    get_data: function (str) {
      xhr = new XMLHttpRequest();

      xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
          console.log(xhr.response);
          answer = xhr.response;
          return JSON.parse(xhr.response);
          //example pour /sauveteurs : [{"_id":str  "id":int "nom": str}]
        }
      }
      //  example: /sauveteurs
      xhr.open("POST", str, true);
      xhr.setRequestHeader("Content-Type", "application/json");
      xhr.send(JSON.stringify({"search": "bruuuuh"}));
    }
  }
});
