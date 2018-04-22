var user = new Vue({
  el: '#user',
  data:{
   users:[]
  },
  methods: {
	  submitForm () {
	    this.$store.dispatch('saveForm')
	    .then(function(res){
	    	console.log(this.data.users)
	    })
	    .catch(function(err){
	    	console.log(err)
	    })
	  }
	}
});