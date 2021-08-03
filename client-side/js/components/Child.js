export default function Child(child) {
    const allergies = child.collection.allergies;
    const preferences = child.collection.preferences;

    return `
    <div class='child__info_containter'>
        <input type='hidden' id='childInfo' value=${child.url} />
        <h2 class='child__name'>${child.firstName}</h2>
        <p>Child age: ${child.age}</p>
        <h3>List of Allergies:</h3>
        ${allergies.map((allergy) => {
            return `
                <p>${allergy}</p>
            `;
        }).join('')}
        <h3>List of preferences:</h3>
        ${preferences.map((preference) => {
            return `
                <p>${preference}</p>
            `;
        }).join('')}
    </div>
    `;
}

// return `
//     <div class='child__info_containter'>
//         <input type='hidden' id='childInfo' value=${child.url} />
//         <h2 class='child__name'>${child.firstName}</h2>
//         <p>Child age: ${child.age}</p>
//         <h3>List of Allergies:</h3>
//         ${child.allergies.map((allergy) => {
//             return `
//                 <p>${allergy}</p>
//             `;
//         }).join('')}
//         <h3>List of preferences:</h3>
//         ${child.preferences.map((preference) => {
//             return `
//                 <p>${preference}</p>
//             `;
//         }).join('')}
//     </div>
//     `;