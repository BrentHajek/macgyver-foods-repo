

export default function ContactPage() {
    return `
    <div class="container">
        <h2 class="contact__us_title">Contact Us</h2>
        <div class="ways__to__contact">
            <article class="contact__us__customer__service">
            <h3 class="general__inquiries__header">For General Inquiries</h3>
                <p>Call our service center at: 1-800-555-8383</p>
                <p> or email <a href="customer__service__email">help@macgyverfoods.com</a></p>
            </article>
            <article class="contact__us__form">
            <h3 class="contact__us__form__header">Send us a Message</h3>
                <form action="contact__page.php" class="fillable__form">
                    <label for="fName">First Name:</label>
                    <input type="text" id="fName" name="firstName" placeholder="Your first name...">
                    <br><label for="lName">Last Name:</label>
                    <input type="text" id="lName" name="lastName" placeholder="Your last name...">
                    <br><label for="email">E-mail:</label>
                    <input type="text" id="email" name="email" placeholder="Your E-mail...">
                    <br><label for="phoneNumber">Last Name:</label>
                    <input type="text" id="phoneNumber" name="phoneNumber" placeholder="Your phone number...">
                    <br><label for="country">Country:</label>
                    <select id="country" name="country">
                        <option value="usa">United States of America</option>
                        <option value="australia">Australia</option>
                        <option value="canada">Canada</option>
                        <option value="ireland">Ireland</option>
                        <option value="jamaica">Jamaica</option>
                        <option value="newZealand">New Zealand</option>
                        <option value="uk">United Kingdom</option>
                        <option value="other">Other Country</option>
                    </select>
                    <br><label for="subject">Subject:</label>
                    <input type="text" id="subject" name="subject" placeholder="Subject...">
                    <br><label for="comments__or__questions">Comments or Questions:</label></form>
                    <textarea id="comments__or__questions" name="comments__or__questions" placeholder="Write something..." style="height:250px"></textarea>
                    <br><input class="contact-input" type="submit" value="Submit">
                </form>
            </article>
        </div>
    </div>
    `;
}