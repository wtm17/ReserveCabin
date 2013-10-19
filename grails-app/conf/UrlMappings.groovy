class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

        "/" {
            controller = "index"
            action = "index"
        }

        "/index.gsp" {
            controller = "index"
            action = "index"
        }
    }
}
