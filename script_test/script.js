const axios = require('axios');

const baseUrl = 'http://localhost:8080';

async function createEquipe(nom, joueurs) {
    try {
        const response = await axios.post(`${baseUrl}/equipes`,
            {
                nom: nom,
                joueurs: joueurs
            });
        console.log('Équipe ', nom, 'créée :', response.data);
        return response.data;
    } catch (error) {
        console.error('Erreur lors de la création de l équipe:');
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
        return response.data;
    } catch (error) {
        console.error('Erreur lors de la création du joueur:', error.response ? error.response.data : error.message);
        throw error;
    }
}
async function getAllJoueurs() {
    try {
        const response = await axios.get(`${baseUrl}/joueurs`);
        console.log("get tout les joueurs : ",response.data);
    } catch (error) {
        console.error(error);
    }
}
async function getJoueur() {
    try {
        const response = await axios.get(`${baseUrl}/joueurs/4`);
        console.log("Get the 4th player")
        console.log(response.data);
    } catch (error) {
        console.error(error);
    }
}

async function deleteJoueur() {
    try {

        const response = await axios.delete(`${baseUrl}/joueurs/7`);
        console.log("Deletion of the 7th player")
    } catch (error) {
        console.error(error);
    }
}
async function putJoueur(joueur_ajoutée) {
    try {
        const response = await axios.put('http://localhost:8080/joueurs', joueur_ajoutée);
        console.log("Modification of the 6th player")
    } catch (error) {
        console.error(error);
    }
}

async function main() {
    try {
        const  joueurs =  []
        const PSG = await createEquipe('PSG',joueurs);
        const ASSE = await createEquipe('ASSE', joueurs);
        console.log(" Creation de l'equipe PSG :  ",PSG.id);
        console.log(" Creation de l'equipe ASSE :  ",ASSE.id);
        const joueur1_equipe1 = await createJoueur("Neymar","Jr","05/02/1992",PSG.id);
        const joueur2_equipe1 = await createJoueur("Kylian","Mbappe","20/12/1998",PSG.id);
        const joueur3_equipe1 = await createJoueur("Achraf","Hakimi","4/11/1998",PSG.id);
        const joueur4_equipe1 = await createJoueur("Neymar","Jr","05/02/1992",PSG.id);
        const joueur1_equipe2 = await createJoueur("Matthieu","Dreyer","20/03/1989",ASSE.id);
        const joueur2_equipe2 = await createJoueur("Gaëtan","Charbonnier","27/12/1988",ASSE.id);
        const joueur3_equipe2 = await createJoueur("Dennis","Appiah","09/06/1992",ASSE.id);
        const joueur4_equipe2 = await createJoueur("Thomas","Monconduit","10/02/1991",ASSE.id);
        getAllJoueurs();
        getJoueur();
        deleteJoueur();
        getJoueur();

        //const joueur2 = await createJoueur(equipe2.id);

        //console.log('Joueur 1 associé à l\'équipe 1:', joueur1);
        //console.log('Joueur 2 associé à l\'équipe 2:', joueur2);
    } catch (error) {
        console.error('Une erreur s\'est produite dans le script principal:', error.message);
    }
}

main();