
var app = new Vue({
  el: "#app",
  data: {
    value_recherche: ""
  },
  methods: {
    get_date: function () {
      xhr = new XMLHttpRequest();

      xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
          answer = xhr.response;
          console.log(xhr.response);
        }
      }

      xhr.open("POST", "/sauveteurs", true);
      xhr.setRequestHeader("Content-Type", "application/json");
      xhr.send(JSON.stringify({"search": "bruuuuh"}));
    }
  }
});
