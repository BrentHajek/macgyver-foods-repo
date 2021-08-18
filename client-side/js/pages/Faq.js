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
                        A drop-down menu will appear. In that drop-down menu, select the Sign In option. A log-in window will then
                        pop up. Click on create an account and enter your e-mail address as your username and create a password.
                        You should now be able to log in.
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
                        more than one if you wish). After you have selected the picky eater accounts you would like to remove, click "Save"
                        and your picky eater's profile will be removed.</p>
            </ul>
        </section>
        <section id="adding-removing-ingredients-to-pantry-section">
            <h3 class="adding-removing-ingredients-to-pantry-title">Managing Your Pantry</h3>
            <ul>
                <li><h4>How do I add ingredients to my pantry?</h4></li>
                    <p></p>
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
                            name and you will see the "Add a Preference" button. Click on that button and you will see a list of food categories. Click on the food
                            category that the ingredient preference you wish to add is in. You will then see a list of ingredients. Select all of the ingredients in that
                            food category that you would like to add and then click "Submit". Your selections will be saved to your child's account.
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
        </section>
    </div>
    `;
}