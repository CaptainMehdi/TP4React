import React from "react";
import {useState} from "react";

const RechercheAuteur = () =>{
    const [auteur,setAuteur] = useState('')
    const [docAuteurs, setDocAuteur] = useState([])

    const fetchTask = async(auteur) => {
        const res = await fetch(`http://localhost:8080/todos/getDocumentAuteur/${auteur}`)
        const data = await res.json()
        return data
    }

    const onSubmit = async (auteur) => {
        const data = await fetchTask(auteur)
        console.log(data)
        setDocAuteur(data)
    }

    return(
        <div>
            <div>
                <div className="container">
                    <form className='add-form' onSubmit={onSubmit}>
                        <div className='form-control'>
                            <label style={{margin: "5px"}}>Titre</label>
                            <input type='text' placeholder='Recherche...'
                                   value={auteur}
                                   onChange={(e) => setAuteur(e.target.value)}/>
                        </div>
                        <input type='submit' value='Rechercher' className='btn btn-block'/>
                    </form>
                    <div>
                        {docAuteurs.map((doc) =>(
                            <div key={doc.id}>
                                {doc.titre}
                            </div>
                            )
                        )}
                    </div>
                </div>
            </div>
        </div>
    )
}
export default RechercheAuteur