export default function FaqPage() {
    return `
    <div class="faq__page">
        <h2 class="faq__title">Frequently Asked Questions</h2>
        <div class="browse-topics-container">
            <h3 class="topics-title">Browse Topics</h3>
            <a href="#account-questions-section"><button>Account Questions</button></a>
            <a href="#adding-removing-children-section"><button>Adding Or Removing Picky Eaters</button></a>
            <a href="#adding-removing-ingredients-to-pantry-section"><button>Managing Your Pantry</button></a>
            <a href="#adding-removing-allergies-section"><button>Managing Allergies In Child Profile</button></a>
            <a href="#adding-removing-preferences-section"><button>Managing Preferences In Child Profile</button></a>
            <a href="#searching-recipes-section"><button>Recipe Searches</button></a>
        </div>
        <section id="account-questions-section">
            <h3 class="account-questions-title">Account Questions</h3>
            <ul>
                <li><h4>How do I create an account?</h4></li>
                    <p>To create an account, make sure you are on the home page. Then, click on the menu button at the top left.
                        A drop-down menu will appear. In that drop-down menu, select the "Sign In" option. A log-in window will then
                        pop up. Click on create an account and enter your e-mail address as your username and create a password.
                        You should now be able to log in.
                    </p>
                <li><h4>Do I have to create an account?</h4></li>
                    <p>To search for recipes according to what ingredients you have on hand and what your child's preferences are,
                        you do not have to create an account. Users who are not signed in are able to select their child's preferences and the
                        ingredients available in their pantry on the home page. However, if your child has allergies and you want to
                        exclude recipes including those food intolerances, you will have to create an account.
                    </p>
            </ul>
        </section>
        <section id="adding-removing-children-section">
            <h3 class="adding-removing-children-title">Adding Or Removing Picky Eaters</h3>
            <ul>
                <li><h4>How do I add a picky eater to my account?</h4></li>
                    <p>To add a picky eater to your child account, first make sure you are signed in. Then click on the profile button at
                        the top right of the menu bar. This will take you to your personal profile. From here you will click the "Add a Child"
                        button. You will then be prompted to enter your child's first and last name as well as their age. After that, click "Save"
                        and your picky eater's profile will be created.
                    </p>
            </ul>
            <ul>
                <li><h4>How do I remove a picky eater account?</h4></li>
                    <p>To remove a picky eater from your child account, first make sure you are signed in. Then click on the profile button at
                        the top right of the menu bar. This will take you to your personal profile. From here you will click the "Remove a Child"
                        button. You will then see a list of all the picky eaters on your account. Select the one you wish to remove (you can select
                        more than one if you wish). After you have selected the picky eater account(s) you would like to remove, click "Save"
                        and your picky eater's profile will be removed.</p>
            </ul>
        </section>
        <section id="adding-removing-ingredients-to-pantry-section">
            <h3 class="adding-removing-ingredients-to-pantry-title">Managing Your Pantry</h3>
            <ul>
                <li><h4>How do I add ingredients to my pantry?</h4></li>
                    <p>To add ingredients to your pantry, make sure you are signed in. Then navigate to your profile page by clicking on the profile
                        icon at the top right of the menu bar. You will see a button called "Add to Pantry". Clicking on this button will bring up a list of
                        ingredients. Click the checkbox next to all the ingredients you wish to add to your pantry and then click "Submit". Your selections
                        will now appear in your pantry which can be found by clicking the basket icon on the menu bar.
                    </p>
                <li><h4>How do I remove ingredients from my pantry?</h4></li>
                    <p>To remove ingredients from your pantry, make sure you are signed in. Then navigate to your profile page by clicking on the profile
                        icon at the top right of the menu bar. You will see a button called "Remove From Pantry". Clicking on this button will bring up a list of
                        all your previously added ingredients. Click the checkbox next to all the ingredients you wish to remove from your pantry and then click
                        "Submit". Your selections will be removed from your pantry. You can find your pantry by clicking the basket icon on the menu bar.
                    </p>
            </ul>
        </section>
        <section id="adding-removing-allergies-section">
            <h3 class="adding-removing-allergies-title">Managing Allergies In Child Profile</h3>
            <ul>
                <li><h4>My picky eater has an allergy. How do I add the allergy to his/her profile so that recipes with that allergen will be excluded?</h4></li>
                    <p>To add an allergy to your child's profile, first make sure you are on your account page. This can be found by clicking the profile
                        button at the top right of the menu bar. Next, locate the name of your child to the right of your account details. Click on your child's
                        name and you will see the "Add an Allergy" button. Click on that button and choose the allergens you would like to add to your child's profile.
                        After you have selected all of the allergy types you wish to add, click "Submit" and your selections will be saved to your child's account.
                    </p>
                <li><h4>I accidentally added the wrong allergy to my child's account. How can I remove it?</h4></li>
                    <p>To remove an allergy from your child's profile, first make sure you are on your account page. This can be found by clicking the profile
                        button at the top right of the menu bar. Next, locate the name of your child to the right of your account details. Click on your child's
                        name and you will see the "Remove an Allergy" button. Click on that button and choose the allergen(s) you would like to remove from your child's
                        profile. After you have selected all of the allergy types you wish to remove, click "Submit" and your selections will be removed from your child's account.
                    </p>
            </ul>
        </section>
        <section id="adding-removing-preferences-section">
            <h3 class="adding-removing-preferences-title">Managing Preferences In Child Profile</h3>
            <ul>
                <li><h4>I want to keep track of the ingredients my picky eater likes. How do I add preferences to my child's account?</h4></li>
                        <p>To add preferences to your child's profile, first make sure you are on your account page. This can be found by clicking the profile
                            button at the top right of the menu bar. Next, locate the name of your child to the right of your account details. Click on your child's
                            name and you will see the "Add a Preference" button. Click on that button and you will see a list of ingredients sorted by food category type.
                            Select all of the ingredients that you would like to add and then click "Submit". Your selections will be saved to your child's account.
                        </p>
                <li><h4>How do I remove preferences from my child's account?</h4></li>
                        <p>To remove preferences from your child's profile, first make sure you are on your account page. This can be found by clicking the profile
                            button at the top right of the menu bar. Next, locate the name of your child to the right of your account details. Click on your child's
                            name and you will see the "Remove a Preference" button. Click on that button and a list of previously added preferences will be shown.
                            Select all of the ingredient preferences that you would like to remove and then click "Submit". Your picky eater's profile will now be updated.
                        </p>
            </ul>
        </section>
        <section id="searching-recipes-section">
            <h3 class="searching-recipes-title">Recipe Searches</h3>
            <ul>
                <li><h4>How do I search for recipes?</h4></li>
                    <p>If you have an account, click on the profile icon at the top right of the menu bar. On this profile page, you can add the ingredients you have on hand to your
                    pantry. You can also add any food allergies your picky eater may have, as well as your picky eater's favorite ingredients. After making these selections, you can find recipes
                    that meet you and your child's needs by clicking on "Search Recipes" located on your child's profile. If you see a dish you are interested in, click the "Learn More" button to
                    see a full list of ingredients needed for the recipe, as well as detailed instructions. Find a recipe you know your picky eater will absolutely love? You can save the recipe
                    to your child's profile by clicking the "Save" button at the bottom of the recipe card. This recipe will now be saved to your child's account and can be found by clicking
                    "My Recipes" on your child's profile.
                    </p>
                <li><h4>Do I need to make an account to search for recipes?</h4></li>
                    <p>If you do not have a profile and do not wish to make one, you can search recipes from the home page. Simply click on the ingredients you have on hand
                            using the food category drop down menus. Then add your picky eater's preferences from the preferences menu. After you have made your
                            selections, click "Search For Recipes" and you will receive recipes that your picky eater will love! Click the "Learn More" button on the recipe card for a full list of
                            ingredients needed, as well as detailed instructions.
                            ***Please note that if your picky eater has food allergies, you will need to have an account to be able to exclude recipes that contain those allergens.
                    </p>
            </ul>
        </section>
        <h3>Have a question that isn't answered here? Please don't hesitate to contact us. Our contact information can be found by clicking the "Contact" option in both the burger menu and the footer menu bar.</h3>
    </div>
    `;
}