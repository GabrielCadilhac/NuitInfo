
var app = new Vue({
  el: "#app",
  data: {
    value_recherche: "",
    onglet: "Home",
    answer: []
  },
  methods: {
    get_data: function (str, send="") {
      xhr = new XMLHttpRequest();

      xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
          console.log(xhr.response);
          app.answer = JSON.parse(xhr.response);
          //example pour /sauveteurs : [{"_id":str  "id":int "nom": str}]
        }
      }
      //  example: /sauveteurs
      xhr.open("POST", str, true);
      xhr.setRequestHeader("Content-Type", "application/json");
      xhr.send(JSON.stringify({"search": send}));

    }
  }
});
