const axios = require('axios');

const baseUrl = 'http://localhost:8080';

async function createEquipe(nom) {
    try {
        const response = await axios.post(`${baseUrl}/equipes`,
            {
                nom: nom,
                joueurs: [
                    { nom: 'nom joueur createequipe 1', prenom: 'prenom joueur 1', dateDeNaissance: '1999-12-12T00:00:00Z'
                    },
                    { nom: 'nom joueur createequipe 2', prenom: 'prenom joueur 2', dateDeNaissance: '2000-01-01T00:00:00Z' }
                ]
            });

        console.log('Équipe créée:', response.data);
        return response.data;
    } catch (error) {
        console.error('Erreur lors de la création de l\'équipe:', error.response ? error.response.data : error.message);
        throw error;
    }
}

async function createJoueur(equipeId) {
    try {
        const response = await axios.post(`${baseUrl}/joueurs`,
            {
                nom: 'nom joueur 1',
                prenom: 'prenom joueur 1',
                dateDeNaissance: '1999-12-12T00:00:00Z',
                equipe: { id: equipeId }
            });

        console.log('Joueur créé:', response.data);
        return response.data;
    } catch (error) {
        console.error('Erreur lors de la création du joueur:', error.response ? error.response.data : error.message);
        throw error;
    }
}


async function main() {
    try {
        const equipe1 = await createEquipe('Équipe 1');
        const equipe2 = await createEquipe('Équipe 2');
        console.log(" equipe 1 id :  ",equipe1.id);
        console.log(" equipe 2 id :  ",equipe2.id);
        const joueur1 = await createJoueur(equipe1.id);

        const joueur2 = await createJoueur(equipe2.id);

        console.log('Joueur 1 associé à l\'équipe 1:', joueur1);
        console.log('Joueur 2 associé à l\'équipe 2:', joueur2);
    } catch (error) {
        console.error('Une erreur s\'est produite dans le script principal:', error.message);
    }
}

main();