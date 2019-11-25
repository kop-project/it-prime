'use strict';

/*
* Блок констант
*/
const HTTP_OK = 200;

/*
*Элементы на странице
*/

let mainCoworkersTable = document.getElementById('coworkersTable');

let xhr = new XMLHttpRequest();
xhr.open('GET', '/api/v1/coworkers');
xhr.send();

xhr.onload = () => {
    if (xhr.status === HTTP_OK) {
        drawRow(xhr.responseText)
    }
};


function drawRow(response) {
    let items = JSON.parse(response);

    items.forEach((item) => {
        let tr = document.createElement('tr');

        let name = document.createElement('td');
        let lastname = document.createElement('td');
        let surname = document.createElement('td');

        let professional = document.createElement('td');
        let department = document.createElement('td');

        name.innerText = item.name;
        lastname.innerText = item.lastname;
        surname.innerText = item.surname;
        tr.appendChild(name);
        tr.appendChild(lastname);
        tr.appendChild(surname);
        tr.appendChild(professional);
        tr.appendChild(department);
        mainCoworkersTable.appendChild(tr);
    });

}

'<tr>\n' +
'                                    <th scope="row">1</th>\n' +
'                                    <td>Cristian</td>\n' +
'                                    <td>Ruiz</td>\n' +
'                                    <td>c.r.username</td>\n' +
'                                    <td>c.r.username@blog.com</td>\n' +
'                                    <td>\n' +
'                                        <a href="#"><i class="fas fa-edit"></i></a> | <a href="#"><i\n' +
'                                            class="fas fa-user-times"></i></a>\n' +
'                                    </td>\n' +
'                                </tr>'