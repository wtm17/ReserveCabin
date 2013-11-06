import reservecabin.Cabin

class BootStrap {

    def init = { servletContext ->
        new Cabin(name:"Cabin 2",description:"Cabin 2",imageUrl:"",phone:"").save()
        new Cabin(name:"Cabin 3",description:"Cabin 3",imageUrl:"",phone:"").save()
        new Cabin(name:"Cabin 4",description:"Cabin 4",imageUrl:"",phone:"").save()
        new Cabin(name:"Cabin 5",description:"Cabin 5",imageUrl:"",phone:"").save()
        new Cabin(name:"Cabin 6",description:"Cabin 6",imageUrl:"",phone:"").save()
        new Cabin(name:"Cabin 7",description:"Cabin 7",imageUrl:"",phone:"").save()
        new Cabin(name:"Cabin 9",description:"Cabin 9",imageUrl:"",phone:"").save()
    }
    def destroy = {
    }
}
