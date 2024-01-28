const axios = require('axios');

const baseUrl = 'http://localhost:8080';

async function createEquipe(nom, joueurs) {
    try {
        const response = await axios.post(`${baseUrl}/equipes`,
            {
                nom: nom,
                joueurs: joueurs
            });
        console.log("Équipe ", nom, "créée :", response.data);
        return response.data;
    } catch (error) {
        console.error("Erreur lors de la création de l équipe:");
        throw error;
    }
}

async function createJoueur(nom, prenom, dateDeNaissance, equipeId) {
    try {
        const response = await axios.post(`${baseUrl}/joueurs`,
            {
                nom: nom,
                prenom: prenom,
                dateDeNaissance: dateDeNaissance,
                equipe: {id: equipeId}
            });
        console.log("Joueur ",response.data.id, " créé")
        return response.data;
    } catch (error) {
        console.error("Erreur lors de la création du joueur:", error.response ? error.response.data : error.message);
        throw error;
    }
}
async function getAllJoueurs() {
    try {
        const response = await axios.get(`${baseUrl}/joueurs`);
        console.log("get tout les joueurs : ",response.data);
        return response.data;
    } catch (error) {
        console.error(error);
    }
}
async function getJoueur() {
    try {
        const response = await axios.get(`${baseUrl}/joueurs/4`);
        console.log("Get joueur 4")
        console.log(response.data);
    } catch (error) {
        console.error(error);
    }
}

async function deleteJoueur() {
    try {
        const response = await axios.delete(`${baseUrl}/joueurs/7`);
        console.log("suppression joueur 7")
        return response.data;
    } catch (error) {
        console.error(error);
    }
}
async function putJoueur(joueur_modifie) {
    try {
        const response = await axios.put(`${baseUrl}/joueurs/6`, joueur_modifie);
        console.log("modification du joueur 6")
        return response.data
    } catch (error) {
        console.error(error);
    }
}

async function main() {
    try {
        const  joueurs =  []
        const joueur_modifie = {
            nom: "Gaëtan modifé",
            prenom: "Charbonnier ",
            dateDeNaissance: "27/12/1988",
            equipe: {
                id: 2,
                nom: "ASSE"
            }
        }
        // creation des équipes
        const PSG = await createEquipe('PSG',joueurs);
        const ASSE = await createEquipe('ASSE', joueurs);
        // création des joueurs avec leurs équipes
        await createJoueur("Neymar","Jr","05/02/1992",PSG.id);
        await createJoueur("Kylian","Mbappe","20/12/1998",PSG.id);
        await createJoueur("Achraf","Hakimi","4/11/1998",PSG.id);
        await createJoueur("Neymar","Jr","05/02/1992",PSG.id);
        await createJoueur("Matthieu","Dreyer","20/03/1989",ASSE.id);
        await createJoueur("Gaëtan","Charbonnier","27/12/1988",ASSE.id);
        await createJoueur("Dennis","Appiah","09/06/1992",ASSE.id);
        await createJoueur("Thomas","Monconduit","10/02/1991",ASSE.id);
        // get tout les joueurs
        await getAllJoueurs();
        // get joueur
        await getJoueur();
        // suppression du joueur dont id = 7
        await deleteJoueur();
        // modification du joueur dont id = 2
        await putJoueur(joueur_modifie)
        // get tout les joueurs apres modifs
        console.log("liste finale après suppression et modifs : ")
        await getAllJoueurs()

    } catch (error) {
        console.error("Une erreur s'est produite dans le script principal:", error.message);
    }
}

main();