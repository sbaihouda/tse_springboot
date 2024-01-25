const axios = require('axios');

const baseUrl = 'http://localhost:8080';

async function createEquipe(nom) {
    try {
        const response = await axios.post(`${baseUrl}/equipes`,  { name: 'Test equipe', players: [{ name :'joueur 1'}, { name :'joueur 2'}] });

        console.log("equipeData ",response.data)
        return response.data;
    } catch (error) {
        console.error('Erreur lors de la création de l\'équipe:', error.response ? error.response.data : error.message);
        throw error;
    }
}

async function createJoueur(nom, age) {
    try {
        const response = await axios.post(`${baseUrl}/joueurs`,  { name: 'Test joueur'});
        return response.data;
    } catch (error) {
        console.error('Erreur lors de la création du joueur:', error.response ? error.response.data : error.message);
        throw error; // Vous pouvez choisir de gérer l'erreur ici ou la relancer pour la propagation
    }
}

async function main() {
    try {
        const equipe1 = await createEquipe("hey");
        const equipe2 = await createEquipe('Équipe B');

        const joueur1 = await createJoueur('Joueur 1', 25);
        const joueur2 = await createJoueur('Joueur 2', 30);

        console.log('Équipe 1 créée:', equipe1);
        console.log('Équipe 2 créée:', equipe2);
        console.log('Joueur 1 créé:', joueur1);
        console.log('Joueur 2 créé:', joueur2);
    } catch (error) {
        console.error('Une erreur s\'est produite dans le script principal:', error.message);
    }
}

main();