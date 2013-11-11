class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

        "/" {
            controller = "ReserveCabin"
            action = "index"
        }

        "/index.gsp" {
            controller = "ReserveCabin"
            action = "index"
        }
    }
}
