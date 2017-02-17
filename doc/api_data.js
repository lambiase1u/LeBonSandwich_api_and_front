define({ "api": [  {    "type": "delete",    "url": "/breads/:id",    "title": "Suppression d'un pain",    "name": "DeletePain",    "group": "Breads",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id du pain</p>"          }        ]      }    },    "success": {      "fields": {        "Success 200": [          {            "group": "Success 200",            "optional": false,            "field": "null",            "description": "<p>null    Le pain a ete supprime</p>"          }        ]      }    },    "error": {      "fields": {        "204": [          {            "group": "204",            "optional": false,            "field": "PainInexistant",            "description": "<p>le pain a supprimer n'existe pas</p>"          }        ],        "401": [          {            "group": "401",            "optional": false,            "field": "NonAutorise",            "description": "<p>token d'authentification invalide</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/BreadRepresentation.java",    "groupTitle": "Breads"  },  {    "type": "get",    "url": "/breads/:id",    "title": "Recuperation d'un pain",    "name": "GetPain",    "group": "Breads",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id du pain</p>"          }        ]      }    },    "success": {      "fields": {        "204": [          {            "group": "204",            "type": "null",            "optional": false,            "field": "null",            "description": "<p>Aucun contenu</p>"          }        ],        "Success 200": [          {            "group": "Success 200",            "type": "Bread",            "optional": false,            "field": "bread",            "description": "<p>Pain recupere</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/BreadRepresentation.java",    "groupTitle": "Breads"  },  {    "type": "get",    "url": "/breads/",    "title": "Recuperation de tous les pains",    "name": "GetPains",    "group": "Breads",    "success": {      "fields": {        "Success 200": [          {            "group": "Success 200",            "type": "ListBread",            "optional": false,            "field": "breads",            "description": "<p>Liste des pains</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/BreadRepresentation.java",    "groupTitle": "Breads"  },  {    "type": "post",    "url": "/breads",    "title": "Creation d'un nouveau pain",    "name": "PostPain",    "group": "Breads",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": "name",            "description": "<p>nom du pain</p>"          }        ]      }    },    "success": {      "fields": {        "201": [          {            "group": "201",            "type": "Bread",            "optional": false,            "field": "bread",            "description": "<p>Pain cree</p>"          }        ]      }    },    "error": {      "fields": {        "400": [          {            "group": "400",            "optional": false,            "field": "NomPainManquant",            "description": "<p>le nom du pain doit etre renseigne</p>"          }        ],        "401": [          {            "group": "401",            "optional": false,            "field": "NonAutorise",            "description": "<p>token d'authentification invalide</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/BreadRepresentation.java",    "groupTitle": "Breads"  },  {    "type": "put",    "url": "/breads/:id",    "title": "Modification d'un pain",    "name": "PutPain",    "group": "Breads",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id du pain</p>"          },          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": "name",            "description": "<p>nom du pain</p>"          }        ]      }    },    "success": {      "fields": {        "Success 200": [          {            "group": "Success 200",            "type": "Bread",            "optional": false,            "field": "bread",            "description": "<p>Pain modifie</p>"          }        ]      }    },    "error": {      "fields": {        "400": [          {            "group": "400",            "optional": false,            "field": "NomPainManquant",            "description": "<p>le nom du pain doit etre renseigne</p>"          }        ],        "401": [          {            "group": "401",            "optional": false,            "field": "NonAutorise",            "description": "<p>token d'authentification invalide</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/BreadRepresentation.java",    "groupTitle": "Breads"  },  {    "type": "delete",    "url": "/categories/:id",    "title": "Suppression d'une categorie",    "name": "DeleteCategories",    "group": "Categories",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id de la categorie</p>"          }        ]      }    },    "success": {      "fields": {        "Success 200": [          {            "group": "Success 200",            "type": "null",            "optional": false,            "field": "null",            "description": "<p>Categorie supprimee</p>"          }        ]      }    },    "error": {      "fields": {        "204": [          {            "group": "204",            "optional": false,            "field": "CategorieInexistante",            "description": "<p>la categorie a supprimer n'existe pas</p>"          }        ],        "401": [          {            "group": "401",            "optional": false,            "field": "NonAutorise",            "description": "<p>token d'authentification invalide</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/CategoryRepresentation.java",    "groupTitle": "Categories"  },  {    "type": "get",    "url": "/categories/",    "title": "Recuperation Liste des categories",    "name": "GetCategories",    "group": "Categories",    "success": {      "fields": {        "Success 200": [          {            "group": "Success 200",            "type": "ListCategory",            "optional": false,            "field": "categories",            "description": "<p>Liste des categories</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/CategoryRepresentation.java",    "groupTitle": "Categories"  },  {    "type": "get",    "url": "/categories/:id",    "title": "Recuperation d'une categorie",    "name": "GetCategory",    "group": "Categories",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id de la catégorie</p>"          }        ]      }    },    "success": {      "fields": {        "Success 200": [          {            "group": "Success 200",            "type": "Category",            "optional": false,            "field": "category",            "description": "<p>Categorie recuperee</p>"          }        ]      }    },    "error": {      "fields": {        "204": [          {            "group": "204",            "optional": false,            "field": "CategorieInexistance",            "description": "<p>la categorie n'existe pas</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/CategoryRepresentation.java",    "groupTitle": "Categories"  },  {    "type": "get",    "url": "/categories/:id/ingredients",    "title": "Recuperation des ingredients associes a une categorie",    "name": "GetIngredientsCategories",    "group": "Categories",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id de la catégorie</p>"          }        ]      }    },    "success": {      "fields": {        "Success 200": [          {            "group": "Success 200",            "type": "ListIngredients",            "optional": false,            "field": "ingredients",            "description": "<p>Liste des ingredients associes</p>"          }        ]      }    },    "error": {      "fields": {        "204": [          {            "group": "204",            "optional": false,            "field": "IngredientsInexistants",            "description": "<p>aucun ingredient n'est associe a la categorie</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/CategoryRepresentation.java",    "groupTitle": "Categories"  },  {    "type": "post",    "url": "/categories/",    "title": "Creation d'une categorie",    "name": "PostCategories",    "group": "Categories",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": "name",            "description": "<p>nom de la catégorie</p>"          },          {            "group": "Parameter",            "type": "Number",            "optional": false,            "field": "limiteNbIngredient",            "description": "<p>limite de ce type d'ingredient par commande</p>"          }        ]      }    },    "success": {      "fields": {        "201": [          {            "group": "201",            "type": "Category",            "optional": false,            "field": "category",            "description": "<p>Categorie creee</p>"          }        ]      }    },    "error": {      "fields": {        "400": [          {            "group": "400",            "optional": false,            "field": "NomCategorieManquant",            "description": "<p>le nom de la categorie est manquant</p>"          }        ],        "401": [          {            "group": "401",            "optional": false,            "field": "NonAutorise",            "description": "<p>token d'authentification invalide</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/CategoryRepresentation.java",    "groupTitle": "Categories"  },  {    "type": "put",    "url": "/categories/:id",    "title": "Modification d'une categorie",    "name": "PutCategories",    "group": "Categories",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id de la categorie</p>"          },          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": "name",            "description": "<p>nom de la catégorie</p>"          },          {            "group": "Parameter",            "type": "Number",            "optional": false,            "field": "limiteNbIngredient",            "description": "<p>limite de ce type d'ingredient par commande</p>"          }        ]      }    },    "success": {      "fields": {        "201": [          {            "group": "201",            "type": "Category",            "optional": false,            "field": "category",            "description": "<p>Categorie creee</p>"          }        ],        "Success 200": [          {            "group": "Success 200",            "type": "Category",            "optional": false,            "field": "category",            "description": "<p>Categorie modifiee</p>"          }        ]      }    },    "error": {      "fields": {        "400": [          {            "group": "400",            "optional": false,            "field": "NomCategorieManquant",            "description": "<p>le nom de la categorie est manquant</p>"          }        ],        "401": [          {            "group": "401",            "optional": false,            "field": "NonAutorise",            "description": "<p>token d'authentification invalide</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/CategoryRepresentation.java",    "groupTitle": "Categories"  },  {    "type": "delete",    "url": "/ingredients/:id",    "title": "Suppression d'un ingredient",    "name": "DeleteIngredients",    "group": "Ingredients",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id de l'ingredient a supprimer</p>"          }        ]      }    },    "success": {      "fields": {        "Success 200": [          {            "group": "Success 200",            "type": "null",            "optional": false,            "field": "null",            "description": "<p>Ingredient supprime</p>"          }        ]      }    },    "error": {      "fields": {        "204": [          {            "group": "204",            "optional": false,            "field": "IngredientInexistant",            "description": "<p>l'ingredient n'existe pas</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/IngredientRepresentation.java",    "groupTitle": "Ingredients"  },  {    "type": "get",    "url": "/ingredients/:id/categories",    "title": "Recuperation de la categorie associee a un ingredient",    "name": "GetCategorieIngredient",    "group": "Ingredients",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id de l'ingredient</p>"          }        ]      }    },    "success": {      "fields": {        "200": [          {            "group": "200",            "type": "Category",            "optional": false,            "field": "category",            "description": "<p>Categorie associee a l'ingredient</p>"          }        ]      }    },    "error": {      "fields": {        "204": [          {            "group": "204",            "optional": false,            "field": "IngredientInexistant",            "description": "<p>l'ingredient n'existe pas</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/IngredientRepresentation.java",    "groupTitle": "Ingredients"  },  {    "type": "get",    "url": "/ingredients/:id",    "title": "Recuperation d'un ingredient",    "name": "GetIngredient",    "group": "Ingredients",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id de l'ingredient</p>"          }        ]      }    },    "success": {      "fields": {        "Success 200": [          {            "group": "Success 200",            "type": "Ingredient",            "optional": false,            "field": "ingredient",            "description": "<p>Ingredient recupere</p>"          }        ]      }    },    "error": {      "fields": {        "204": [          {            "group": "204",            "optional": false,            "field": "IngredientInexistant",            "description": "<p>l'ingredient n'existe pas</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/IngredientRepresentation.java",    "groupTitle": "Ingredients"  },  {    "type": "get",    "url": "/ingredients/",    "title": "Recuperation liste des ingredients",    "name": "GetIngredientsList",    "group": "Ingredients",    "success": {      "fields": {        "Success 200": [          {            "group": "Success 200",            "type": "ListIngredient",            "optional": false,            "field": "ingredients",            "description": "<p>Liste des ingredients</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/IngredientRepresentation.java",    "groupTitle": "Ingredients"  },  {    "type": "post",    "url": "/ingredients/",    "title": "Creation d'un ingredient",    "name": "PostIngredients",    "group": "Ingredients",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": "idCateg",            "description": "<p>id de la catégorie de l'ingredient</p>"          },          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": "nameIng",            "description": "<p>nom de l'ingredient</p>"          }        ]      }    },    "success": {      "fields": {        "201": [          {            "group": "201",            "type": "Ingredient",            "optional": false,            "field": "ingredient",            "description": "<p>Ingredient cree</p>"          }        ]      }    },    "error": {      "fields": {        "400": [          {            "group": "400",            "optional": false,            "field": "idCateg",            "description": "<p>l'id de la categorie est manquant</p>"          },          {            "group": "400",            "optional": false,            "field": "nameIng",            "description": "<p>le nom de l'ingredient est manquant</p>"          }        ],        "401": [          {            "group": "401",            "optional": false,            "field": "NonAutorise",            "description": "<p>token d'authentification invalide</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/IngredientRepresentation.java",    "groupTitle": "Ingredients"  },  {    "type": "put",    "url": "/ingredients/:id",    "title": "Modification d'un ingredient",    "name": "PutIngredients",    "group": "Ingredients",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id de l'ingredient</p>"          },          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": "idCateg",            "description": "<p>id de la categorie</p>"          },          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": "nameIng",            "description": "<p>nom de l'ingredient</p>"          }        ]      }    },    "success": {      "fields": {        "201": [          {            "group": "201",            "type": "Ingredient",            "optional": false,            "field": "ingredient",            "description": "<p>Ingredient cree</p>"          }        ],        "Success 200": [          {            "group": "Success 200",            "type": "Ingredient",            "optional": false,            "field": "ingredient",            "description": "<p>Ingredient modifie</p>"          }        ]      }    },    "error": {      "fields": {        "400": [          {            "group": "400",            "optional": false,            "field": "idCateg",            "description": "<p>l'id de la categorie est manquant</p>"          },          {            "group": "400",            "optional": false,            "field": "nameIng",            "description": "<p>le nom de l'ingredient est manquant</p>"          }        ],        "401": [          {            "group": "401",            "optional": false,            "field": "NonAutorise",            "description": "<p>token d'authentification invalide</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/IngredientRepresentation.java",    "groupTitle": "Ingredients"  },  {    "type": "delete",    "url": "/sandwichs/:id",    "title": "Suppresion d'un sandwich",    "name": "DeleteSandwichs",    "group": "Sandwichs",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id du sandwich a supprimer</p>"          }        ]      }    },    "success": {      "fields": {        "200": [          {            "group": "200",            "type": "null",            "optional": false,            "field": "null",            "description": "<p>Sandwich supprime</p>"          }        ]      }    },    "error": {      "fields": {        "204": [          {            "group": "204",            "optional": false,            "field": "sandwichInexistant",            "description": "<p>le sandwich n'existe pas</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/SandwichRepresentation.java",    "groupTitle": "Sandwichs"  },  {    "type": "get",    "url": "/sandwichs/:id/breads",    "title": "Recuperation pain associe au sandwich",    "name": "GetBreadSandwichs",    "group": "Sandwichs",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id du sandwich</p>"          }        ]      }    },    "success": {      "fields": {        "200": [          {            "group": "200",            "type": "Bread",            "optional": false,            "field": "bread",            "description": "<p>Pain du sandwich</p>"          }        ]      }    },    "error": {      "fields": {        "204": [          {            "group": "204",            "optional": false,            "field": "SandwichInexistant",            "description": "<p>Le sandwich n'existe pas</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/SandwichRepresentation.java",    "groupTitle": "Sandwichs"  },  {    "type": "get",    "url": "/sandwichs/:id/ingredients",    "title": "Recuperation liste des ingredients associes au sandwich",    "name": "GetIngredientsSandwich",    "group": "Sandwichs",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id du sandwich</p>"          }        ]      }    },    "success": {      "fields": {        "200": [          {            "group": "200",            "type": "ListIngredients",            "optional": false,            "field": "listIngredients",            "description": "<p>Liste des ingredients qui composent le sandwich</p>"          }        ]      }    },    "error": {      "fields": {        "204": [          {            "group": "204",            "optional": false,            "field": "SandwichInexistant",            "description": "<p>le sandwich n'existe pas</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/SandwichRepresentation.java",    "groupTitle": "Sandwichs"  },  {    "type": "get",    "url": "/sandwichs/",    "title": "Recuperation liste des sandwichs",    "name": "GetListSandwichs",    "group": "Sandwichs",    "success": {      "fields": {        "200": [          {            "group": "200",            "type": "ListSandwich",            "optional": false,            "field": "listSandwich",            "description": "<p>Liste des sandwichs</p>"          }        ]      }    },    "error": {      "fields": {        "204": [          {            "group": "204",            "optional": false,            "field": "SandwichsManquants",            "description": "<p>aucun sandwich enregistre</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/SandwichRepresentation.java",    "groupTitle": "Sandwichs"  },  {    "type": "get",    "url": "/sandwichs/:id",    "title": "Recuperation d'un sandwich",    "name": "GetSandwichs",    "group": "Sandwichs",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id du sandwich</p>"          }        ]      }    },    "success": {      "fields": {        "200": [          {            "group": "200",            "type": "Sandwich",            "optional": false,            "field": "sandwich",            "description": "<p>Sandwich recupere</p>"          }        ]      }    },    "error": {      "fields": {        "204": [          {            "group": "204",            "optional": false,            "field": "sandwichInexistant",            "description": "<p>le sandwich n'existe pas</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/SandwichRepresentation.java",    "groupTitle": "Sandwichs"  },  {    "type": "post",    "url": "/sandwichs/",    "title": "Creation d'un sandwich",    "name": "PostSandwichs",    "group": "Sandwichs",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": "idBread",            "description": "<p>id du pain du sandwich</p>"          },          {            "group": "Parameter",            "type": "Number",            "optional": false,            "field": "taille",            "description": "<p>taille du sandwich</p>"          },          {            "group": "Parameter",            "type": "ListIdIngredients",            "optional": false,            "field": "idIngredients",            "description": "<p>liste des id des ingredients qui composent le sandwich</p>"          }        ]      }    },    "success": {      "fields": {        "201": [          {            "group": "201",            "type": "Sandwich",            "optional": false,            "field": "sandwich",            "description": "<p>Sandwich cree</p>"          }        ]      }    },    "error": {      "fields": {        "400": [          {            "group": "400",            "optional": false,            "field": "idBreadManquant",            "description": "<p>id du pain manquant</p>"          },          {            "group": "400",            "optional": false,            "field": "tailleManquant",            "description": "<p>la taille du sandwich est manquante</p>"          },          {            "group": "400",            "optional": false,            "field": "idIngredientsManquant",            "description": "<p>la liste des ingredients est manquante</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/SandwichRepresentation.java",    "groupTitle": "Sandwichs"  },  {    "type": "put",    "url": "/sandwichs/:id",    "title": "Modification d'un sandwich",    "name": "PutSandwichs",    "group": "Sandwichs",    "parameter": {      "fields": {        "Parameter": [          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": ":id",            "description": "<p>id du sandwich a modifier</p>"          },          {            "group": "Parameter",            "type": "String",            "optional": false,            "field": "idBread",            "description": "<p>id du pain du sandwich</p>"          },          {            "group": "Parameter",            "type": "Number",            "optional": false,            "field": "taille",            "description": "<p>taille du sandwich</p>"          },          {            "group": "Parameter",            "type": "ListIdIngredients",            "optional": false,            "field": "idIngredients",            "description": "<p>liste des id des ingredients qui composent le sandwich</p>"          }        ]      }    },    "success": {      "fields": {        "200": [          {            "group": "200",            "type": "Sandwich",            "optional": false,            "field": "sandwich",            "description": "<p>Sandwich cree</p>"          }        ]      }    },    "error": {      "fields": {        "204": [          {            "group": "204",            "optional": false,            "field": "sandwichInexistant",            "description": "<p>le sandwich n'existe pas</p>"          }        ],        "400": [          {            "group": "400",            "optional": false,            "field": "idBreadManquant",            "description": "<p>id du pain manquant</p>"          },          {            "group": "400",            "optional": false,            "field": "tailleManquant",            "description": "<p>la taille du sandwich est manquante</p>"          },          {            "group": "400",            "optional": false,            "field": "idIngredientsManquant",            "description": "<p>la liste des ingredients est manquante</p>"          }        ]      }    },    "version": "0.0.0",    "filename": "./src/main/java/boundary/SandwichRepresentation.java",    "groupTitle": "Sandwichs"  },  {    "success": {      "fields": {        "Success 200": [          {            "group": "Success 200",            "optional": false,            "field": "varname1",            "description": "<p>No type.</p>"          },          {            "group": "Success 200",            "type": "String",            "optional": false,            "field": "varname2",            "description": "<p>With type.</p>"          }        ]      }    },    "type": "",    "url": "",    "version": "0.0.0",    "filename": "./doc/main.js",    "group": "_Users_quentin_Dropbox_Licence_Pro_Java_LeBonSandwich_api_and_front_doc_main_js",    "groupTitle": "_Users_quentin_Dropbox_Licence_Pro_Java_LeBonSandwich_api_and_front_doc_main_js",    "name": ""  }] });
