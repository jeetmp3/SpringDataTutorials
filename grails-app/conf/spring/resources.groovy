import demo.data.config.SpringDataMongodbConfig

// Place your Spring DSL code here
beans = {
    springDataMongodbConfig(SpringDataMongodbConfig) {
        grailsApplication = ref("grailsApplication")
    }
}
